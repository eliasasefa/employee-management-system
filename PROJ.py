import pyttsx3
from gtts import gTTS, lang
import os
from tkinter import *
from tkinter import messagebox

win = Tk()
win.config(bg='grey')
win.title('++Text to speech converter++')
win.geometry('1100x670')

frame=Frame(win, bg='green', bd=10,width=800,height=720, relief=RIDGE)
frame.grid(row=0, column=0)
frame1=Frame(frame, bd=10, bg='yellow', width=700,height=350, relief=RIDGE)
frame2=Frame(frame,bd=10,bg='pink', relief=RIDGE,width=400,height=350)
head=Frame(frame,bd=5, width=100,height=5,relief=RIDGE)

head.grid(row=0,column=0)
frame1.grid(row=1, column=0)
frame2.grid(row=1, column=1)

text = StringVar()
sliderFrame=Frame(frame2,width=100,height=20,bd=2)
sliderLabel=Label(sliderFrame,text='SPEECH RATE')
hdLabel=Label(head, fg='blue',font=24,
              text='\nHARAMAYA UNIVERSITY\nDEPARTMENT OF SOFTWARE ENGINEERING\nGROUP 5\n')
hdLabel.grid(row=0,column=2)
entryLabel = Label(frame1, text='        Enter Text here      ')
word = Text(frame1,width=80,height=16)
val= IntVar()
horz = Scale(sliderFrame, from_=100, to=400,
             orient=HORIZONTAL, width=12, length=300)

def slide():
    engine = pyttsx3.init()
    myLab = Label(win, text=horz.get())
    val = horz.get()
    return

def sayMale():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')
    engine.setProperty('voice', voices[0].id)
    text = (word.get("1.0", "end-1c"))
    if(len(text) <= 0):
        messagebox.showerror(message="Text field is empty")
        return
    val=horz.get()
    engine.setProperty('rate', val)
    engine.say(text)
    #engine.save_to_file(text, "femaleSPeech.mp3")
    engine.runAndWait()
    engine.stop()
    return

def sayFemale():
    engine = pyttsx3.init()
    text = (word.get("1.0", "end-1c"))
    if(len(text) <= 0):
        messagebox.showerror(message="Text field is empty")
        return
    val=horz.get()
    engine.setProperty('rate', val)
    voices = engine.getProperty("voices")
    engine.setProperty("voice", voices[1].id)
    engine.say(text)
    engine.runAndWait()
    engine.stop()
    return

#save to file
def saveToFile():
    engine = pyttsx3.init()
    text: str = (word.get("1.0", "end-1c"))
    if(len(text) <= 0):
        messagebox.showerror(message="Text field is empty")
        return
    val=horz.get()
    engine.setProperty('rate', val)
    voices = engine.getProperty("voices")
    engine.setProperty("voice", voices[1].id)
    engine.save_to_file(text, "speech.mp3")
    engine.runAndWait()
    return

# exit function
def ext():
    win.destroy()

def reset():
    word.delete(1.0,END)

# Defining buttons
entryLabel.grid(row=0,column=0)
word.grid(row=1, column=0)

femaleButton = Button(frame2, text='PLAY FEMALE VOICE',
                      activebackground='green', width=50, command=sayFemale)
femaleButton.grid(row=0, column=0)

maleButton = Button(frame2, width=50,bg="magenta", text='PLAY MALE VOICE',
                    activebackground='green', command=sayMale)
maleButton.grid(row=1, column=0)

reset = Button(frame2,bg="cyan", width=50,
               text='RESET TEXT FIELD',activebackground='green', command=reset)
reset.grid(row=2, column=0)

exitButton = Button(frame2, width=50, text="EXIT", bg='pink',
                    activebackground='red', command=ext)
exitButton.grid(row=3, column=0)
save_btn=Button(frame2,text='SAVE TO FILE',bg='cyan', command=saveToFile).grid(row=7,column=0)

sliderFrame.grid(row=5, column=0)
Label(frame2,text='').grid(row=12,column=0)
Label(frame2,text='').grid(row=8,column=0)
Label(frame2,text='').grid(row=9,column=0)
Label(frame2,text='').grid(row=10,column=0)
Label(frame2,text='').grid(row=11,column=0)
sliderLabel.grid(row=0,column=0)
horz.grid(row=0,column=1)

win.mainloop()

#end of program