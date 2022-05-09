// include the library code:

#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <AltSoftSerial.h>

#include <SoftwareSerial.h>
#include <Wire.h>

String command;
int commandInt;

//moisture sensor
int sensor_pin = A0;
int output_value = 0;
int moisture;

//
#define RE 10
#define DE 11

const byte nitro[] = {0x01,0x03, 0x00, 0x1e, 0x00, 0x01, 0xb5, 0xcc};
const byte phos[] = {0x01,0x03, 0x00, 0x1f, 0x00, 0x01, 0xe4, 0x0c};
const byte pota[] = {0x01,0x03, 0x00, 0x20, 0x00, 0x01, 0x85, 0xc0};
byte values[11];
SoftwareSerial mod(12,13);

#define OLED_RESET 4
Adafruit_SSD1306 display(OLED_RESET);

#define NUMFLAKES 10
#define XPOS 0
#define YPOS 1
#define DELTAY 2


#define LOGO16_GLCD_HEIGHT 32
#define LOGO16_GLCD_WIDTH  128 

//pins for front buttons yellow - lamp, blue - water, green - lighting (might be removed)
const int lampb = 5;
const int waterb = 6;
const int lightingb = 7;
//pins for relays
const int pumpPin = 2;
const int lampPin = 3;
//states
int lampbState = 0;
int waterbState = 0;
int lightingbState = 0;
//for tracking whether the lamp is on
int lampState = 0; 
//used for making bottons toggle-able and prevent looping while button is pressed

void setup() {
  Serial.begin(9600);
  mod.begin(9600);
  pinMode(RE, OUTPUT);
  pinMode(DE, OUTPUT);

  pinMode(lampb,INPUT);
  pinMode(waterb,INPUT);
  pinMode(lightingb,INPUT);
  
  pinMode(pumpPin,OUTPUT);
  pinMode(lampPin,OUTPUT);

  digitalWrite(lampPin, LOW);
  digitalWrite(pumpPin, LOW);
  
  display.begin(SSD1306_SWITCHCAPVCC, 0x3C);  // initialize with the I2C addr 0x3C (for the 128x32)
  //display.display();
  delay(2000);
  display.clearDisplay(); 
}

void loop() {
  //check if any button was pressed
  lampbState = digitalRead(lampb);
  waterbState = digitalRead(waterb);
  lightingbState = digitalRead(lightingb);

  if (lampbState == HIGH && lampState == 0){ //If yellow button was pressed...
    lamp(1);
    delay(500);
  } else if(lampbState == HIGH && lampState == 1) {
    lamp(0);
    delay(500);
  }

  //Water button on device will use pumping level 1 (low)
  if (waterbState == HIGH) pump(1);

  //For now, lighting button (green) will be used to activate the pump without timers
  if (lightingbState == HIGH) digitalWrite(pumpPin, HIGH);
  else digitalWrite(pumpPin, LOW);



  if(Serial.available() > 0) {
    command = Serial.readStringUntil('\n');
    command.trim();
    commandInt = command.toInt();
    if (commandInt == 21) pump(1);
    else if (commandInt == 22) pump(2);
    else if (commandInt == 23) pump(3);
    else if (commandInt == 11) lamp(1);
    else if (commandInt == 10) lamp(0);
    else if (commandInt == 31) pump(1);
    else if (commandInt == 32) pump(2);
    else if (commandInt == 33) pump(3);
  }
  
  byte val1,val2,val3;
  val1 = nitrogen();
  val2 = phosphorous();
  val3 = potassium();

  Serial.print(output_value);
  Serial.print(",");
  Serial.print(val1);
  Serial.print(",");
  Serial.print(val2);
  Serial.print(",");
  Serial.println(val3);

  
  moisture = analogRead(sensor_pin);

  output_value = (86000 - (moisture * 100))/4000;
  if (moisture > 759) output_value = 0;
  else if (moisture < 261) output_value = 100;
  
  
  
  display.clearDisplay();
 
  robojaxText("N:", 4, 3, 1, false);
  robojaxText(String(val1), 14, 3, 1, false);
  
  robojaxText("P:", 50, 3, 1, false);
  robojaxText(String(val2), 60, 3, 1, false);
  
  robojaxText("K:", 96, 3, 1, false);
  robojaxText(String(val3), 106, 3, 1, false);

  robojaxText("Moisture:", 4, 11, 1, false);
  robojaxText(String(output_value), 60, 11, 1, false);

  //use the bottom of the screen to display whatever you want
  //robojaxText("bottom row", 4, 21, 1, false);
  
  display.drawRect(1, 1, 126,31, WHITE);
  display.display();

  
  delay(1000);
}
byte nitrogen(){
  digitalWrite(DE,HIGH);
  digitalWrite(RE,HIGH);
  delay(10);
  if(mod.write(nitro,sizeof(nitro))==8){
    digitalWrite(DE,LOW);
    digitalWrite(RE,LOW);
    for(byte i=0;i<7;i++){
      values[i] = mod.read();
    }
  }
  return values[4];
}
 
byte phosphorous(){
  digitalWrite(DE,HIGH);
  digitalWrite(RE,HIGH);
  delay(10);
  if(mod.write(phos,sizeof(phos))==8){
    digitalWrite(DE,LOW);
    digitalWrite(RE,LOW);
    for(byte i=0;i<7;i++){
      values[i] = mod.read();
    }
  }
  return values[4];
}
 
byte potassium(){
  digitalWrite(DE,HIGH);
  digitalWrite(RE,HIGH);
  delay(10);
  if(mod.write(pota,sizeof(pota))==8){
    digitalWrite(DE,LOW);
    digitalWrite(RE,LOW);
    for(byte i=0;i<7;i++){
      values[i] = mod.read();
    }
  }
  return values[4];
}

void robojaxText(String text, int x, int y,int size, boolean d) {

  display.setTextSize(size);
  display.setTextColor(WHITE);
  display.setCursor(x,y);
  display.println(text);
  if(d){
    display.display();
  }
}

//0 to turn off. 1 to turn on
void lamp(int input) {
  if (input == 0) {
    digitalWrite(lampPin, LOW);
    lampState = 0;
  }
  else if (input == 1) {
    digitalWrite(lampPin, HIGH);
    lampState = 1;
  }
}

//delay(1000) equals 1 second
void pump(int input) {
  digitalWrite(pumpPin, HIGH);
  if (input == 1) delay(5000);
  else if (input == 2) delay(10000); 
  else if (input == 3) delay(15000); 
  digitalWrite(pumpPin, LOW);
}
