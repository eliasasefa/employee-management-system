#include<iostream>
#include<fstream>
#include<string>
#include<stdio.h>

const int nHome = 4;
const int Pmonth = 2790;
const int Proom = 1250;
struct record{
   char fname[25];
   char lname[25];
   int phone;
}records; 
void disp_reg();
void login();
void reg();
void disp();
void menu();
void house();
void calculation();
void admn();
void H_status(int n);
using namespace std;

int main()/*entering into main function*/
{
    cout << "\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n";
    cout << "\t\t\t\tWELCOME TO OROMIA HOUSE RENTING PAGE\n\n\n";
    cout << "\t\t\t\tHELLO, WHAT CAN I HELP YOU? PLEASE SELECT YOUR OPTION HERE.\n\n";
    cout << "\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n";
    cout << "\n\n";
    login();
    system("pause>0");     
    return 0;
}
 void login()   /*definition of function login. */
 {
     string username;
     string password;          /*variables declaration.*/
     string user;
     char pass[8];
     ifstream pasin;
     pasin.open("pass.txt", ios::out | ios::in | ios::app);

     if (pasin.is_open())  /*checking if a file is correctly opened*/
     {
         pasin >> user;
         pasin >> pass;
         username = user;
         password = pass;
         pasin.close();/*closing a file*/

     }
     string usertrial, userpassword;
   
    cout << "\t\t\t\t\t1  Login\n\n";
    cout << "\t\t\t\t\t2  Exit\n\n";
    char option;
    cout << "\t\t\t\t\t_";
    cin >> option;
    switch (option)  /*using a switch case to enter options*/
    {
    case '1':
        cin.ignore();
        cout << "\n\t\t Enter username ";
        cin >> usertrial;
        cout << "\n\t\t Enter your password ";
        cin >> userpassword;
        cin.clear();
        if (usertrial == username && userpassword == password)
        {
            cout << "\n\n\t\t\t\tWELL COME!\n";
            menu();
        }
        if (usertrial != username && userpassword != password)
        {
            cout << "\tinvalid username and incorrect password." << endl;
        }
        else if (userpassword != password)
        {
            cout << "\tincorrect password\n";
        }
        else if (usertrial != username)
        {
            cout << "\n\tinvalid username" << endl;
        }
        else
            cout << endl;
        if (usertrial != username || userpassword != password)
        {
            login();
        }
        break;
    case '2':
    {
        cout << "\n\tOperation successfully cancelled";
        exit(0);
    }
    default: cout << "\n\tPlease Enter valid option and try again" << endl;
        login();     /*calling the function login if the user unable to login.*/
    }
}
void reg()    /*definition of function reg. to redister a renter */
{
    ifstream input;
    ofstream output;
    input.open("registration.txt");
    output.open("registration.txt", ios::app);
    cin.ignore();
   
   cout << "\n\tEnter first name";
   cin >> records.fname;
   output << records.fname<<"  ";
   cout << "\n\tenter last name ";
   cin >> records.lname;
   output << records.lname<<"  ";
   cout << "\n\tenter phone number ";
   cin >> records.phone;
   output << records.phone << "  "<<endl;
    input.close();
    output.close();
    menu();
}
void disp()      /*definition of function disp.*/
{               
    cout << "\tplease select from below options\n";
         
    cout<<"\n\t\t1. Available House"
        <<"\n\t\t2. To register renter"
        <<"\n\t\t3. to know the price"
        <<"\n\t\t4. to return back"<<endl;
    cout << "\t\t\t";
    char type;
    cin >> type;
    switch (type)
    {
    case '1':house();
        break;
    case '2':reg(); menu();
        break;
    case '3':calculation();
        menu();
        break;
    case '4':menu();
    }
    menu();
}
void menu()        /*Definition of function menu*/
{
    cout << "\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    cout<<"\n\t\t\t\t1. to display houses\n"
        << "\t\t\t\t2. for registeration\n"
        << "\t\t\t\t3. to display the renters information\n"
        <<" \t\t\t\t4. to change password\n"
        <<" \t\t\t\t5. to change house status\n"
        <<" \t\t\t\t6. to know prices and assign renters\n"
        << "\t\t\t\tx. to close the system\n";
    cout << "\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    cout << "\n\t\t\t\t_";
    char op;
    cin >> op;
    switch (op) 
  {
        cin.clear();
    case '1':   house();     break;
    case '2':   reg();       break;
    case '3':   disp_reg();  break;
    case '4':   admn();      break;
    case '5':   H_status(4); break;
    case '6':  disp();       break;
    case 'x':   cout << "\t\t\tGoodbye!\n";      exit(0);
    default :    cout << "\t\tinvalid input, please try again\n";
        cout << "\n\n";
        menu();
  }
}
void calculation()     /*Definition of function calculation .*/
{
    ifstream in;
    ofstream out;
    in.open("months.txt", ios::app);
    out.open("months.txt", ios::app);
    float month, Nroom;
    cin.ignore();
    cout << "\n\t\tplease enter number of months _";
    cin>> month;
    out <<"\n\tNumber of months = "<< month<<endl;
    cout << "\n\t\tPlease enter number of rooms _";
    cin >> Nroom;
    out <<"\n\tnumber of rooms = "<< Nroom<<endl;
    float price = (Pmonth+Nroom * Proom) * month;
    out << "\n\tPrice = " << price << endl;
    cout << "\n\t\tPrice after "<<month<<" months is = " << price << "ETB.\n";
    cout << "\n\t\tThank you.\n\n";
    in.close();
    out.close();
}
void house()        /*Definition of function house .*/
{    
    bool a = true;
    do
    {
        cout << "\t\t\t~~~~~~~~LIST OF OROMIA HOUSES~~~~~~~~\n\n"
            <<"\t\t\tNo.         House Name\n\n"
            << "\t\t\t1. Family Home (3 rooms) \n"
            << "\t\t\t2. Family Home (2 rooms) \n"
            << "\t\t\t3. Conferencing Rooms \n"
            << "\t\t\t4. House of Single Room\n\n";
        cout << "\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        cout << "\n\t\t\tSTATUS OF HOMES IS GIVEN BELOW.\n\n";
        cout << "\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        ifstream inp;
        ofstream outp;
        inp.open("status.txt", ios::in);
        if (inp.is_open())
        {
            string status;
            int i = 1;
                while (getline(inp,status) && i <= nHome)
                {                 
                        cout << "\n\t\tHouse number " << i << " is " << status << endl;
                        i++;
                }
            inp.close();
        }
        else
        cout << "unable to open" << endl;
        a = 0;
    } while (a);
    menu();
}
 void disp_reg()  /*Definition of function disp_reg. it is used to display registratin info.*/
 {
    ifstream input;
    input.open("registration.txt",ios::in|ios::out);
    string fname;
    string lname;
    int phone;
    if (input.is_open())
    {
        cout << "\n\n";
        cout << "\tFirst name    |Last name    |Phone number" << endl;
        cout << "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        while (!input.eof())
        {
            cout << "\n\n";
            input >> fname;
            cout<<'\t' << fname <<'\t';
            input >> lname;
            cout<<'\t' << lname << "\t";
            input >> phone;
            cout<<'\t' << phone << "\t" << endl;
        }
        input.close();
    }
     else
     cout << "unable to open" << endl;
    menu();
}
void admn()    /*Definition of function admn. */
{                              /*contains admnistrative operations */
    string password, username;
    string usertrial, userpassword, user;
    char pass[8];
    ifstream pasin;
    ofstream pasout;

    pasin.open("pass.txt", ios::out | ios::in);
    pasout.open("pass.txt");
    cout << "\n\tEnter new username ";
    cin >> user;
    cout << "\n\tEnter new password ";
    cin >> pass;
    pasout << user << " " << pass << endl;
    pasin.close();
    pasout.close();
    pasin.open("pass.txt", ios::out | ios::in);

    if (pasin.is_open()) /*checks if a file is open*/
    {
        pasin >> user;
        pasin >> pass;
        username = user;
        password =pass;
        pasin.close();
        pasout.close();
    }
    menu();
}
void H_status(int n)  /*Definition of function H_status*/
{
    ifstream inp;
    ofstream outp;
    inp.open("status.txt",ios::in|ios::out);
    outp.open("status.txt");
    string status;

    if (inp.is_open())
    {
        for (int i = 1; i < 5; i++)
        {
            cout << "\nEnter details of house number "<<i<<" status ";
            cin >> status;
            outp << status<<endl;
        }  
        inp.close(); 
        outp.close();
        menu();
    }
    else
    cout << "unable to open" << endl;
}

