
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
    <ol>
        <li>	Performance Requirements	                </li>
        <li>	Safety Requirements	                        </li>
        <li>	Security Requirements	                    </li>
        <li>	Software Quality Attributes	                </li>
        <li>	Business Rules	                            </li>
    </ol>
</li>
<li>Other Requirements	                                
</li></ol>
<ul>    
<li>Appendix A: Glossary	                                </li>
<li>Appendix B: Analysis Models	                            </li>
<li>Appendix C: To Be Determined List	                    </li>
</ul></i>


<b>Revision History</b>
<table width="50%">
<tr>
    <td>S. No</td>
    <td>Name</td>
    <td>Date</td>
    <td>Reason For Changes</td>
    <td>Version</td>
</tr>
<tr>
    <td>1</td>
</tr>
<tr>
    <td>2</td>
</tr>    
</table>







<b>1. Introduction</b>

<b>1.1 Purpose</b> 
<p>The ‘Food Ordering App’ is an android application designed for restaurants to ease the communication with their customers. The purpose is to remove any ‘middlemen charges’ that are applied by other food applications. Individual restaurants will have their own personalized application for food delivery and/or ordering in-dining.
</p>

<b>1.2 Document Conventions</b>
<p>There are no special conventions in this document.
</p>

<b>1.3 Intended Audience and Reading Suggestions</b>
<p>This document is intended for faculty of Software Engineering Course and the members involved in developing this product. The reader may start reading from section 2.1.
</p>

<b>1.4 Product Scope</b>
<p>The purpose of this project is for each restaurant to have its own personalized app with multiple uses like: 
    <ul>
        <li>Personalized Loyalty Programs</li>
        <li>Delivery management and tracking</li>
        <li>Inventory management</li>
        <li>Comprehensive menu display</li>
    </ul></p>

<b>1.5 References</b><ol>    
        <li> Material Design Google - https://material.io/design/</li>
        <li> Firebase Google - https://firebase.google.com/</li>
    </ol>
<br>
<b>2. Overall Description</b>

<b>2.1 Product Perspective</b>
<p>A new, self-contained product leveraging the features of Firebase real-time DBMS and the Android app eco-system, Firebase provides database management for features such as Order History, Menu, Inventory, etc.
</p>

<b>2.2 Product Functions</b>
<p><ul>
    <li> Menu Display                           </li>
    <li> Delivery Ordering                      </li>
    <li> Delivery Tracking                      </li>
    <li> Loyalty Programs                       </li>
    <li> Order History                          </li>
    <li> Bill Payment                           </li>
  </ul></p> 

<b>2.3 User Classes and Characteristics</b>
<p>Users of the system should be able to view the menu and order for delivery once logged in. The user can also pay the bill in-app when dining in or during delivery.	The user can redeem their loyalty points for various benefits.The app will support two types of user privileges staff and customer.
Staff user can (in addition to customer user):
<ul>
    <li> Cancel order                   </li>
    <li> Edit Menu                      </li>
    <li> Change delivery status         </li>
    <li> Edit offers                    </li>
    <li> View all orders                </li>
</ul></p>

<b>2.4 Operating Environment</b>
<p><ul>
    <li>Client/server system
    <li> Operating System: Android
    <li> Database: Firebase NoSQL
    <li> Platform: Java.
</ul><p>

<b>2.5 Design and Implementation Constraints</b>
<p>Implementation of loyalty programs and offers, delivery feature is up to the restaurant requirement.
</p>

<b>2.6 User Documentation</b>
<p>A basic user documentation will be made available to the project customer containing details about how to use the app.
</p>

<b>2.7 Assumptions and Dependencies</b>
<p>TBD
</p>
<br>
<b>3. External Interface Requirements</b>


<b>3.1 User Interfaces</b>
<p>Front-end: Material Design Based Android front-end
   Back-end: Firebase Database
</p>

<b>3.2 Hardware Interfaces</b>
<p>Android 4.4 and above.
</p>

<b>3.3 Software Interfaces</b>
<p><ul>
    <li>Software used: Android Studio 3.2               </li>
    <li>Operating system: Android 4.4 and above         </li>
    <li>Database: Firebase by Google                    </li>
    <li>Language: Java                                  </li>
</ul></p>

<b>3.4 Communications Interfaces</b>
<p>The app can run on any Android Phone having Google Apps as it requires Google SSO to authenticate. All database connections are secured and encrypted by HTTPS .
</p>
<br>
<b>4. System Features</b>

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




<i>Copyright © 2018 by NU. Permission is granted to distribute this document.</i>





