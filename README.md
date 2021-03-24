# e-tickets
System for electronic tickets


This is my first java project for Uni. I developed it in my 3rd Semester, when I started learnign Java. 
It is written in Java and it is simple without any save option at the moment.


The code must model an elementary system issuance of an electronic ticket (e-ticket) for the MMM 
that enables the user to issue it and renew it.

Each ticket is characterized at least by the type (electronic or printed), its type
(normal or reduced), its duration (90 minutes, daily, weekly, monthly), the number
of routes (1, 5, 11) and its price. In case of reduced or monthly ticket
we also have the following information: holder name, ticket code and
expiration date.


The scenario that it had to be implemented is as follows: The user, by logging in to
application selects from a list of actions which it is interested in. 

The actions are:

1. Issue-purchase
In this case, he first chooses the type of ticket. Depending on the
His choice can choose either the number of routes or the duration. In
In case of his reduced or monthly ticket, he is asked to register in addition the
his details. Finally, the price is presented to him and he must choose a payment method
(cash or card). After paying, the option to receive the ticket is presented
(electronic or printing). In case he chooses electronics, an email is requested
shipment.

2. Renewal
If he chooses this action he can buy either extra routes or extra
time depending on the type of ticket. Finally the price is presented and it should
choose a method of payment (cash or card). After paying, the option is presented
ticket receipt (electronic or print). In case he chooses
his email is requested to send an email.

3. Content update
If he chooses to update the content, he should be presented with his details
ticket.
