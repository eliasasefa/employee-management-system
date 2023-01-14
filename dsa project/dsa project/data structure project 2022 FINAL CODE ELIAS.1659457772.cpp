/*THIS PROGRMAM IMPLENTS LINKED LIST ON STUDENT REGISTRATION SYSTEM
 * WE HAVE USED THE FUNCITIONALITIES REQUIRED BY OUR TEACHER
 * THIS PROGRAM STORES STUDENT INFORMATION TEMPORARILY
 */

#include<iostream>
#include<iomanip>
#include<string>
using namespace std;
struct node
{
string name;
string department;
int rollno;
float gpa;
string id;      //id may be of form '0917/13'...char included
node *next;
node *head=NULL;
};
node *head = new node();
void addNewStudent();
void display();
void search();
int deleteStudent();
void asc_name_sorting ();
void asc_id_sorting();
void asc_gpa_sorting();
void update();

//delete
int deleteStudent(){
    node* t = head;
	node* p = NULL;
 int rollno;
 	if (t == NULL) {
		cout << "Record does not Exist\n";
		return -1;
	}
 cout<<"enter roll no to delete: ";
 cin>>rollno;
 
	if (t != NULL
		&& t->rollno == rollno) {
		head = t->next;
		delete t;
		cout << "Record Deleted Successfully\n";
		return 0;
	}
	while (t != NULL && t->rollno != rollno) {
		p = t;
		t = t->next;
	}
		p->next = t->next;
		delete t;
		cout << "Record Deleted Successfully\n";
		return 0;
}
                          //registration
void addNewStudent()
{
 cout<<"\n Enter student information here\n"<<endl;
 node *temp = new node();
 cout<<"Enter full name: ";
 cin.ignore();
 getline(cin, temp->name);
 cout<<"Enter department: ";
 getline(cin, temp->department);
 cout<<"Enter roll number: ";
 cin>>temp->rollno;
 cout<<"Enter GPA: ";
 cin>>temp->gpa;
 cout<<"Enter ID: ";
 cin>>temp->id;
 if(head==NULL){
   temp->next=head;
   head=temp;
 }
 else{
   node *temp2=new node();
   temp2=head;
   while(temp2->next!=NULL && temp2->next->rollno<temp->rollno){
    temp2=temp2->next;
   }
   temp->next=temp2->next;
   temp2->next=temp;
 }
cout<<"student registered successfully!"<<endl;
}
void menu(){
 char op;
 char choice;
do{
 cout<<"Enter 1 to display records\n"
       "Enter 2 to register student\n"
       "Enter 3 to delete student\n"
       "Enter 4 to search by id.no\n"
       "Enter 5 to sort student by name\n"
       "Enter 6 to sort student by id\n"
       "Enter 7 to sort student by GPA(Ascending)\n"
       "Enter 8 to update student information\n"
       "Enter 0 to exit"<<endl;
       cout<<">>>";
  cin>>choice;
	switch(choice){
		case '1':display();
			 break;
		case '2': addNewStudent();
			 break;
		case '3': deleteStudent();
			 break;
		case '4':search();
			 break;
	    case '5': asc_name_sorting();
	    	 break;
		case '6':asc_id_sorting();
			break;
		case '7':asc_gpa_sorting();
			break;
		case '8':update();
			break;
		case '0':exit(0);

		default:cout<<"invalid input, please try again\n"<<endl;
			 menu();
	}
	cout<<"\npress any key to continue, (x) to exit\n"<<endl;
	cout<<">>>";
	cin>>op;
}while(!(op=='x' || op=='X'));
}
//****************************************************
int main(){
cout<<"*********************************************************"<<endl;
cout<<"*                                                       *"<<endl;
cout<<"*    STUDENT REGISTRATION SYSTEM USING LINKED LIST      *"<<endl;
cout<<"*                                                       *"<<endl;
cout<<"*                                                       *"<<endl;
cout<<"*                                                       *"<<endl;
cout<<"*********************************************************"<<endl;
 head=NULL;
 menu();
return 0;
}
              //diplay function
void display(){
 node *stud=head;
stud=head;
if(stud==NULL)
 cout<<"no data"<<endl;
else{
cout<<"-------------------------------------------------------------------------"<<endl;
cout<<"roll.no| Name\t\t  | Department\t\t|  ID\t\t| GPA"<<endl;
cout<<"-------------------------------------------------------------------------"<<endl;
  int count=1;
while(stud!=NULL)
{
   cout<<setw(3)<<stud->rollno<<". ";
   cout<<setw(15)<<stud->name<<"\t ";
   cout<<setw(20)<<stud->department<<"\t";
   cout<<setw(10)<<stud->id<<"\t";
   cout<<setw(7)<<stud->gpa<<endl;
   stud=stud->next;
   count++;
   }
  }
}
//           search function
void search(){
if(head==NULL)
	 cout<<"Empty list"<<endl;
else{
	 bool found=false;
	 string key;
	 cout<<"Enter your id to search>>>";
	 cin>>key;
	 node* current = head;
	 
	 while ((current!=NULL) && !found){
		if(current->id == key){
		 cout<<"This student is found in the record\n"<<endl;
cout<<"-------------------------------------------------------------------------"<<endl;
cout<<"roll.no| Name\t\t  | Department\t\t|  ID\t\t| GPA"<<endl;
cout<<"-------------------------------------------------------------------------"<<endl;
   cout<<setw(3)<<current->rollno<<". ";
   cout<<setw(15)<<current->name<<"\t ";
   cout<<setw(20)<<current->department<<"\t";
   cout<<setw(10)<<current->id<<"\t";
   cout<<setw(7)<<current->gpa<<endl;
		 found=true;
		}
    current = current->next;
	}
	if (found==true){}
	else{
            cout<<"student you searched does not found in this record"<<endl;
        }
   }   
}
//sorting name by name

void asc_name_sorting ()
{
	struct	node * temphead = head;
	struct node *i,*j;
		int temproll;
		string tempname;
		string tempdep;
		float tempgpa;
		string tempid;
		int counter = 0;
		temphead = head;
	//                  check against empty list
if(temphead==NULL){
	cout<<"empty list"<<endl;
	return;
}
else
{
	for (j=temphead; j!=NULL; j=j->next)
	{
		while (temphead->next!=NULL)
		{
			if (temphead->name > temphead->next->name)
			{
				temproll = temphead->rollno;
				temphead->rollno = temphead->next->rollno;     //rollno
				temphead->next->rollno = temproll;

				tempname = temphead->name;
				temphead->name = temphead->next->name;    //name
				temphead->next->name = tempname;
				
				tempgpa = temphead->gpa;
				temphead->gpa = temphead->next->gpa;   //gpa
				temphead->next->gpa = tempgpa;

				tempdep = temphead->department;
				temphead->department = temphead->next->department;    //dep
				temphead->next->department = tempdep;
				
				tempid = temphead->id;
				temphead->id = temphead->next->id;        //id
				temphead->next->id = tempid;
			}
			temphead = temphead->next;
		}	
		temphead = head;
	}
	cout<<"sorted successfully"<<endl;
	return;
 }
}
//   sort by id
void asc_id_sorting ()
{
struct	node * temphead = head;
struct node *i,*j;
	int temproll;
	string tempname;
	string tempdep;
	float tempgpa;
	string tempid;
	temphead = head;

if(temphead==NULL){
	cout<<"empty list"<<endl;
	return;
}
else
{
	for (j=temphead; j->next!=NULL; j=j->next)
	{
		while (temphead->next!=NULL)
		{
			if (temphead->id > temphead->next->id)
			{
				temproll = temphead->rollno;
				temphead->rollno = temphead->next->rollno;     //rollno
				temphead->next->rollno = temproll;

				tempname = temphead->name;
				temphead->name = temphead->next->name;    //name
				temphead->next->name = tempname;

				tempgpa = temphead->gpa;
				temphead->gpa = temphead->next->gpa;   //gpa
				temphead->next->gpa = tempgpa;

				tempdep = temphead->department;
				temphead->department = temphead->next->department;    //dep
				temphead->next->department = tempdep;

				tempid = temphead->id;
				temphead->id = temphead->next->id;        //id
				temphead->next->id = tempid;
			}
			temphead = temphead->next;
		}
		temphead = head;
	}
	cout<<"sorted successfully"<<endl;
	return;
 }
}
// sort by gpa
void asc_gpa_sorting ()
{
struct	node * temphead = head;
struct node *i,*j;
	int temproll;
	string tempname;
	string tempdep;
	float tempgpa;
	string tempid;
	temphead = head;

if(temphead==NULL){
	cout<<"empty list"<<endl;
	return;
}
else
{
	for (j=temphead; j->next!=NULL; j=j->next)
	{
		while (temphead->next!=NULL)
		{
			if (temphead->gpa > temphead->next->gpa)
			{
				temproll = temphead->rollno;
				temphead->rollno = temphead->next->rollno;     //rollno
				temphead->next->rollno = temproll;

				tempname = temphead->name;
				temphead->name = temphead->next->name;    //name
				temphead->next->name = tempname;

				tempgpa = temphead->gpa;
				temphead->gpa = temphead->next->gpa;   //gpa
				temphead->next->gpa = tempgpa;

				tempdep = temphead->department;
				temphead->department = temphead->next->department;    //dep
				temphead->next->department = tempdep;

				tempid = temphead->id;
				temphead->id = temphead->next->id;        //id
				temphead->next->id = tempid;
			}
			temphead = temphead->next;
		}
		temphead = head;
	}
	cout<<"sorted successfully"<<endl;
	return;
 }
}
//    update function
void update()
{
	string tempname;
	string tempdepartment;
	int temprollno;
	float tempgpa;
	string tempid;
	node *next;
	bool isUpdated=false;
	if(head==NULL)
    cout<<"Empty list"<<endl;
	else{
		 string key;
		 cout<<"Enter ID to update: ";
		 cin>>key;
		 node* current = head;
		while (current!=NULL && !isUpdated){
			if(current->id == key){

			 int option;
			 cout<<"Enter 1	to update name\n"
				   "Enter 2 to update department\n"
				   "Enter 3	to update id\n"
				   "Enter 4	to update roll number\n"
				   "Enter 5	to update GPA\n"
				   "Enter 6	to update all data\n"
				   "Enter 7	back to main menu\n";
				   cout<<">>>";
				   cin>>option;
				   
				   switch(option){
				   	case 1:
				   		cout<<"Enter new name>>>";
				   		cin.ignore();
						getline(cin,tempname);
						current->name=tempname;
				   		break;                            //name
					case 2:
						cout<<"Enter new department>>>";
				   		cin.ignore();
						getline(cin,tempdepartment);
						current->department=tempdepartment;
				   		break;                            //dep
					case 3:
						cout<<"Enter new ID>>>";
				   		cin.ignore();
						getline(cin,tempid);
						current->id=tempid;
				   		break;                            //id
					case 4:
						cout<<"Enter new roll number>>>";
						cin>>temprollno;
						current->rollno=temprollno;
				   		break;                            //roll
   		            case 5:
   		            	cout<<"Enter new GPA>>>";
						cin>>tempgpa;
						current->gpa=tempgpa;
   		            	break;                            //gpa
   		           	case 6:
   		           		cout<<"Enter new name>>>";
				   		cin.ignore();
						getline(cin,tempname);
						current->name=tempname;
						
						cout<<"Enter new department>>>";
						getline(cin,tempdepartment);
						current->department=tempdepartment;
						
						cout<<"Enter new ID>>>";
						getline(cin,tempid);
						current->id=tempid;
						cout<<"Enter new roll number>>>";
						cin>>temprollno;
						current->rollno=temprollno;
						
						cout<<"Enter new GPA>>>";
						cin>>tempgpa;
						current->gpa=tempgpa;
				   		break;                            //all data
   		            case 7:menu();           //menu
				   		break;
					default:cout<<"invalid input, please try again\n";
						break;
				   }
			 isUpdated=true;
			}
	    current = current->next;
		}
		if (isUpdated==true)
		cout<<"updated successfully"<<endl;
		else{
	            cout<<"student not found"<<endl;
	        }
   }
}

//end of my program
