5. Write a menu driven program for above menu

This application will be used by store owner(admin) or customers. Consider two users are already there in the system for simplicity.
Admin User (loginId=admin, password = admin)
Customer (loginId=c1, password=c1)

Login is required to perform any operation. Without login, access to any functionality will throw exception.

Store owner can perform any operation after login.

A customer can browse, order and check status of his order after login.

Customer can’t access Admin only functionalities like Add Pet, Update Pet, Update order status etc. Accessing Admin only functionality by customer will throw Unauthorized exception

Pet Store Application Menu:
Login
Add new Pet (Admin only functionality)
Update Pet details (Admin only functionality)
Display all available pets
Order a Pet
Check order status by Order Id
Update order status (Admin only functionality)
Exit

Core classes
Pet ( petId, name, category, unitPrice, stocks)
Category is an enum with values like (CAT, DOG, RABBIT, FISH)
Example:
  petId = 101, name=” Bull Dog”, category= DOG, unitPrice= 1000, stocks=50

Order (orderId, petId, quantity, status)
Status is an enum with values like (PLACED, IN_PROCESS, COMPLETED)
Example:
   orderId=1, petId=101, quantity=5, status=PLACED

Hints :
Create classes, Enums – Pet, Order, Category, Status
Create required exception classes – AuthenticationException, AuthorizationException, OutOfStockException
Handle exceptions
Menu creation, using suitable collection classes for storing Pet and Order
Login
Auto Order Id generation
Adjusting stocks after an order, order quantity should not be less than available stock