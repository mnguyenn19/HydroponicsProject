import serial
import time
import schedule
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db

cred = credentials.Certificate('ponx-b6b7b-firebase-adminsdk-vnw7q-b11d3c5874.json')

firebase_admin.initialize_app(cred, {
    'databaseURL': 'https://ponx-b6b7b-default-rtdb.firebaseio.com/'
})

#Receiving serial communication from the open USB port that Arduino is connected to
ser = serial.Serial('/dev/ttyACM0',9600,timeout=1)
ser.flush()

#Inital creation of realtime database elements
"""
ref = db.reference('/')
ref.set({
    
    'data': {
        'moisture': {
            'Name':'Moisture',
            'Value': '0',
            'Abrev':'H20',
            'Image':''
        },
        'nitrogen': {
            'Name':'Nitrogen',
            'Value': '0',
            'Abrev':'N',
            'Image':''
        },
        'phosphorus': {
            'Name':'Phosphorus',
            'Value': '0',
            'Abrev':'P',
            'Image':''
        },
        'potassium': {
            'Name':'Potassium',
            'Value': '0',
            'Abrev':'K',
            'Image':''
        }
    }
    
})
"""
#Set reference point of the database 'ref' to start at parent node 'data'
ref = db.reference('data')
ref2 = db.reference('light/Power')
ref21 = db.reference('light')
ref3 = db.reference('scheduleData/Intensity')
ref4 = db.reference('water/Power')
ref41 = db.reference('water')

def setwaterIntensity():
    if ser.in_waiting > 0:
        if (intensityVal == 'high'):
            ser.write(b"23\n")
            print("Setting water intensity to high")
        elif (intensityVal == 'medium'):
            ser.write(b"22\n")
            print("Setting water intensity to medium")
        elif (intensityVal == 'low'):
            ser.write(b"21\n")
            print("Setting water intensity to low")

def setLight(x):
    if ser.in_waiting > 0:
        if (x == 'on'):
            ser.write(b"11\n")
            ref21.update({
                'Power' : 'none'
            })
            print("Activating light")
        elif (x == 'off'):
            ser.write(b"10\n")
            ref21.update({
                'Power' : 'none'
            })
            print("Deactivating light")
        elif (x == 'none'):
            pass
            
def setWater(x):
    if ser.in_waiting > 0:
        if (x == 'low'):
            ser.write(b"31\n")
            ref41.update({
                'Power' : 'none'
            })
            print("Activating low water")
        elif (x == 'medium'):
            ser.write(b"32\n")
            ref41.update({
                'Power' : 'none'
            })
            print("Activating medium water")
        elif (x == 'high'):
            ser.write(b"33\n")
            ref41.update({
                'Power' : 'none'
            })
            print("Activating high water")
        elif (x == 'none'):
            pass
            
        
#Schedule function, top one is for demo day demonstration while bottom one is for normal usage        
schedule.every(20).minutes.do(setwaterIntensity)
#schedule.every().day.at("09:00").do(setwaterIntensity)


if __name__ == '__main__':
    
    #While loop to keep running the python script as long as RasPi is on
    while True:
        waterVal = ref4.get()
        intensityVal = ref3.get()
        lightVal = ref2.get()
        
        setLight(lightVal)
        setWater(waterVal)
        
        schedule.run_pending()
        #Read in data from serial port and split it into multiple variables for processing
        if ser.in_waiting > 0:
            line = ser.readline().decode('utf-8').rstrip()
            dataSplit = line.split(',')
            moistureVal = dataSplit[0]
            nitrogenVal = dataSplit[1]
            phosphorusVal = dataSplit[2]
            potassiumVal = dataSplit[3]
            
            #Updating values in the database as received from sensors
            ref.update({
                'moisture/Value':moistureVal,
                'nitrogen/Value':nitrogenVal,
                'phosphorus/Value':phosphorusVal,
                'potassium/Value':potassiumVal
            })
            
            
            
            #Put loop on sleep for 5 seconds to lower the amount of read and writes to the database
            time.sleep(5)
            
