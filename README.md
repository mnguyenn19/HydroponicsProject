# CSE 4316/4316 - PonX
Hydroponics creates an easy-to-use hydroponics gardening system that is controlled by the home gardener via their phone application. Customers will be able to watering and light the system and maintenance duration all through our phone application.

## Vision Statement
Ponx aims to minimize the total 
amount of work the user has to 
perform in order to tend to their 
plant indoors by allowing users to:

- Control
- Automate
- Monitor their plants

easily while they are not in the 
immediate vicinity of the device. 
PonX hopes to encourage users to 
grow healthy, tasty,  fresh and 
nutritious food indoors.


## Information
PonX is a soil based hydroponics system that provides the opportunity for customers who would like to start a garden without access to outdoor gardening space all year round.

## Compile Instructions
App is being developed on Android Studio, so for the best results app should be compiled via Android Studio
1) Install the lastest version of Android Studio, Arduino IDE, and preferred Python IDE
  - If using a Raspberry Pi you may use the default Thonny IDE that comes pre-installed
2) Pull the most current version of the code onto your computer

#### App
3) Open the project in Android Studio
4) Next under Tools>AVD Manager click on create virtual device
5) To compile and run you can do so by going to Run>Run 'main' or by clicking on the run button on the toolbar
  - Device created earlier may needs to be opened first in which case can be opened from the toolbar as well in the drop down menu of "no devices"

#### Server
7) Open the "NPK.ino" under the "NPK" folder in your Arduino IDE
8) Upload the sketch to the connected Arduino using the button located at the top left of the IDE
9) Open your preferred Python IDE and open the "server_script.py" file under the "Server Script" folder
10) Run the python script and keep the console open

## Helpful Links
#### Downloads
- `Android Studio Download`: (https://developer.android.com/studio)
- `Arduino IDE Download`: (https://www.arduino.cc/en/software)
#### Install Instructions
- `Android Studio`: [Install Guide](https://developer.android.com/studio/install)
- `Wiring Schematics`: [Image](https://raw.githubusercontent.com/mnguyenn19/HydroponicsProject/master/NPK/Schematic.png)
#### Hydroponics
- `Hydroponics - PonX Website`: [Link](https://blog.uta.edu/cseseniordesign/2022/04/21/hydroponics/)
