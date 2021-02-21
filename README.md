# ezypay-subscription-service by Naresh Siramsetty

## Description

This is a simple java & spring boot based microservice to generate invoice dates based on subscription type, start date, end date etc.

### Run Locally , you can access end points via localhost:8080

```bash
./gradlew bootRun
```

### Run Test Cases

```bash
./gradlew test
```

### Deployment

I have deployed this microservice into heroku web.

Please find below examples to run directly from deployed service.

```bash
curl --location --request POST 'https://shrouded-fjord-62935.herokuapp.com/api/subscriptions' \
--header 'Content-Type: application/json' \
--data-raw '{ 
    "amount" : 10.00,
    "startDate" : "01/01/2021",
    "endDate" : "01/04/2021",
    "subscriptionType": "DAILY"
}'
```
Response :
```bash
{
    "amount": 10.0,
    "invoiceDates": [
        "01/01/2021",
        "02/01/2021",
        "03/01/2021",
        "04/01/2021",
        "05/01/2021",
        "06/01/2021",
        "07/01/2021",
        "08/01/2021",
        "09/01/2021",
        "10/01/2021",
        "11/01/2021",
        "12/01/2021",
        "13/01/2021",
        "14/01/2021",
        "15/01/2021",
        "16/01/2021",
        "17/01/2021",
        "18/01/2021",
        "19/01/2021",
        "20/01/2021",
        "21/01/2021",
        "22/01/2021",
        "23/01/2021",
        "24/01/2021",
        "25/01/2021",
        "26/01/2021",
        "27/01/2021",
        "28/01/2021",
        "29/01/2021",
        "30/01/2021",
        "31/01/2021",
        "01/02/2021",
        "02/02/2021",
        "03/02/2021",
        "04/02/2021",
        "05/02/2021",
        "06/02/2021",
        "07/02/2021",
        "08/02/2021",
        "09/02/2021",
        "10/02/2021",
        "11/02/2021",
        "12/02/2021",
        "13/02/2021",
        "14/02/2021",
        "15/02/2021",
        "16/02/2021",
        "17/02/2021",
        "18/02/2021",
        "19/02/2021",
        "20/02/2021",
        "21/02/2021",
        "22/02/2021",
        "23/02/2021",
        "24/02/2021",
        "25/02/2021",
        "26/02/2021",
        "27/02/2021",
        "28/02/2021",
        "01/03/2021",
        "02/03/2021",
        "03/03/2021",
        "04/03/2021",
        "05/03/2021",
        "06/03/2021",
        "07/03/2021",
        "08/03/2021",
        "09/03/2021",
        "10/03/2021",
        "11/03/2021",
        "12/03/2021",
        "13/03/2021",
        "14/03/2021",
        "15/03/2021",
        "16/03/2021",
        "17/03/2021",
        "18/03/2021",
        "19/03/2021",
        "20/03/2021",
        "21/03/2021",
        "22/03/2021",
        "23/03/2021",
        "24/03/2021",
        "25/03/2021",
        "26/03/2021",
        "27/03/2021",
        "28/03/2021",
        "29/03/2021",
        "30/03/2021",
        "31/03/2021",
        "01/04/2021"
    ],
    "subscriptionType": "DAILY"
}
```

```bash
curl --location --request POST 'https://shrouded-fjord-62935.herokuapp.com/api/subscriptions' \
--header 'Content-Type: application/json' \
--data-raw '{ 
    "amount" : 10.00,
    "startDate" : "01/01/2021",
    "endDate" : "01/04/2021",
    "subscriptionType": "WEEKLY",
    "dayOfTheWeek" : "THURSDAY"
}'
```
Response :
```bash
{
    "amount": 10.0,
    "invoiceDates": [
        "07/01/2021",
        "14/01/2021",
        "21/01/2021",
        "28/01/2021",
        "04/02/2021",
        "11/02/2021",
        "18/02/2021",
        "25/02/2021",
        "04/03/2021",
        "11/03/2021",
        "18/03/2021",
        "25/03/2021",
        "01/04/2021"
    ],
    "subscriptionType": "WEEKLY"
}
```

```bash
curl --location --request POST 'https://shrouded-fjord-62935.herokuapp.com/api/subscriptions' \
--header 'Content-Type: application/json' \
--data-raw '{ 
    "amount" : 10.00,
    "startDate" : "01/01/2021",
    "endDate" : "01/04/2021",
    "subscriptionType": "MONTHLY",
    "dayOfTheMonth" : 13
}'
```
Response :
```bash
{
    "amount": 10.0,
    "invoiceDates": [
        "13/01/2021",
        "13/02/2021",
        "13/03/2021"
    ],
    "subscriptionType": "MONTHLY"
}
```