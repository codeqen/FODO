
<b><h1>SOFTWARE REQUIREMENTS SPECIFICATION</h1><br> 
<h3>FODO (Food Ordering App)</h3>

<h4>Version 1.0 approved</h4>

Prepared by</b> 
<ul>
    <li>Sagnik Mitra</li>
    <li>Yash Rastogi</li>
    <li>Simran Singh</li>
    <li>Abhijit Singh</li>
</ul>    

<b>NIIT University

30th August, 2018</b>


<b>Table of Contents</b>

<i>
<ul>
    <li>Revision History</li>
</ul>
<ol>
<li>Introduction	                                
    <ol>
        <li>    Purpose	                                    </li> 
        <li>	Document Conventions	                    </li> 
        <li>	Intended Audience and Reading Suggestions   </li>
        <li>	Product Scope	                            </li>
        <li>	References	                                </li>
    </ol>
</li>
<li>Overall Description	
    <ol>
        <li>	Product Perspective	                        </li>
        <li>	Product Functions                           </li>	
        <li>	User Classes and Characteristics	        </li>
        <li>	Operating Environment	                    </li>
        <li>	Design and Implementation Constraints	    </li>
        <li>	User Documentation	                        </li>
        <li>	Assumptions and Dependencies	            </li>
    </ol>    
</li>
<li>External Interface Requirements
    <ol>
        <li>	User Interfaces	                            </li>
        <li>	Hardware Interfaces	                        </li>
        <li>	Software Interfaces	                        </li>
        <li>	Communications Interfaces	                </li>
    </ol>
</li>    
<li>System Features	  
    <ol>
        <li>	System Feature 1	                        </li>
        <li>	System Feature 2 (and so on)	            </li>
    </ol>
</li>
<li>Other Nonfunctional Requirements	
5.1	Performance Requirements	4
5.2	Safety Requirements	5
5.3	Security Requirements	5
5.4	Software Quality Attributes	5
5.5	Business Rules	5
6.	Other Requirements	5
Appendix A: Glossary	5
Appendix B: Analysis Models	5
Appendix C: To Be Determined List	6</i>


<b>Revision History</b>

Name
Date
Reason For Changes
Version









<b>1. Introduction</b>

<b>1.1 Purpose</b> 
The ‘Food Ordering App’ is an android application designed for restaurants to ease the communication with their customers. The purpose is to remove any ‘middlemen charges’ that are applied by other food applications. Individual restaurants will have their own personalized application for food delivery and/or ordering in-dining.

<b>1.2 Document Conventions</b>
There are no special conventions in this document.

<b>1.3 Intended Audience and Reading Suggestions</b>
This document is intended for faculty of Software Engineering Course and the members involved in developing this product. The reader may start reading from section 2.1.

<b>1.4 Product Scope</b>
<p>The purpose of this project is for each restaurant to have its own personalized app with multiple uses like: <li><l1>Personalized Loyalty Programs</l1><l2>Delivery management and tracking</l2><l3>Inventory management</l3><l4>Comprehensive menu display</l4></li></p>

<b>1.5 References</b>
    1. Material Design Google - https://material.io/design/
    2. Firebase Google - https://firebase.google.com/


2. Overall Description

2.1 Product Perspective
A new, self-contained product leveraging the features of Firebase real-time DBMS and the Android app eco-system, Firebase provides database management for features such as Order History, Menu, Inventory, etc.

2.2 Product Functions
• Menu Display
• Delivery Ordering
• Delivery Tracking
• Loyalty Programs
• Order History
• Bill Payment

2.3 User Classes and Characteristics
Users of the system should be able to view the menu and order for delivery once logged in. The user can also pay the bill in-app when dining in or during delivery.	The user can redeem their loyalty points for various benefits.The app will support two types of user privileges staff and customer.
Staff user can (in addition to customer user):
• Cancel order
• Edit Menu
• Change delivery status
• Edit offers
• View all orders

2.4 Operating Environment
• Client/server system
• Operating System: Android
• Database: Firebase NoSQL
• Platform: Java.

2.5 Design and Implementation Constraints
Implementation of loyalty programs and offers, delivery feature is up to the restaurant requirement.

2.6 User Documentation
A basic user documentation will be made available to the project customer containing details about how to use the app.

2.7 Assumptions and Dependencies
TBD


3. External Interface Requirements

3.1 User Interfaces
Front-end: Material Design Based Android front-end
Back-end: Firebase Database

3.2 Hardware Interfaces
Android 4.4 and above.

3.3 Software Interfaces
Software used
Android Studio 3.2
Operating system
Android 4.4 and above
Database
Firebase by Google
Java
To implement the project we have chosen Java language as its the primary language for development in Android

3.4 Communications Interfaces
The app can run on any Android Phone having Google Apps as it requires Google SSO to authenticate. All database connections are secured and encrypted by HTTPS .


4. System Features

4.1 Sign-In

4.1.1	Description and Priority
The user will sign in to verify whether it’s a human or a bot. It has a higher priority since every action in this app will depend on this.
4.1.2	Stimulus/Response Sequences
Based on the user’s sign-in Info (Name, Phone Number) the order will be placed.
4.1.3	Functional Requirements
TBD

4.2 Ordering Food through the Menu provided

4.2.1	Description and Priority
The user will select their desired items and place it in order phase. 
4.2.2	Stimulus/Response Sequences
TBD
4.2.3	Functional Requirements
TBD

4.3 Check availability
4.3.1	Description and Priority
The user will provide address for delivery to check whether it can be reached by the specific restaurant or not.
4.3.2	Stimulus/Response Sequences
TBD
4.3.3	Functional Requirements
TBD


5. Other Nonfunctional Requirements

5.1 Performance Requirements
No such requirements needed since the application is expected to be of smaller size and run on android ver. 4.4 and above. 

5.2 Safety Requirements
The app is in development process. Currently, there are no safety issues.

5.3 Security Requirements
The users may need to verify themselves (google sign-in or any other authentication) if we implement payment option in our product. Otherwise, there is no such requirement in the current phase of our product.  

5.4 Software Quality Attributes
TBD

5.5 Business Rules
TBD


6. Other Requirements
TBD
Appendix A: Glossary
ver. - version
Appendix B: Analysis Models
It will be determined based on the development of our product.
Appendix C: To Be Determined List
<Collect a numbered list of the TBD (to be determined) references that remain in the SRS so they can be tracked to closure.>


Software Requirements Specification for FODO		Page 5


<br>
<i><font size=6>Copyright © 2018 by NU. Permission is granted to distribute this document.</font></i>





