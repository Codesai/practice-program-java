# Unusual Spending Kata

You work at a credit card company and as a value-add they want to start providing alerts to users when their spending in any particular category is higher than usual.

Each `Payment` comes with a `price`, `description`, and `category`. A `Category` represents a collection of payments (e. g. "entertainment", "restaurants", "rent", ...).

This is what the new service should do:

For a given user, you have to compare the total amount paid for the last two months, grouped by category; and filter down to the categories for which the user spent at least 50% more this month than last month, (you'll fetch from a DB all the user payments for the current month and the previous month). 

Then you have to compose an e-mail message to the user that lists the categories for which spending was unusually high, with a subject like: "Unusual spending of $1076 detected!" and a body like:

```
Hello card user!

We have detected unusually high spending on your card in these categories:

* You spent $148 on groceries
* You spent $928 on travel

Love,

The Credit Card Company
```

[Original kata](https://github.com/testdouble/contributing-tests/wiki/Unusual-Spending-Kata)
