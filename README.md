# CHARS-IN-SEQUENCE REST API

This repository provides a **REST API** that takes a _post_ request as a string to check
and returns a _JSON_ response with amount of each character, and it's frequency in string.

# HOW TO USE

    To send post request you also can use Postman or it's analogue

After starting an API, you need to send a post request by mapping `/getAllSequenceElementsCount`

## Format of request

```text
your_string
```

## Format of response

```json
[
  {
    "r": 2
  },
  {
    "y": 1
  },
  {
    "o": 1
  },
  {
    "u": 1
  },
  {
    "_": 1
  }
]
```

`...`

# RESTRICTIONS

There is only one rule: **Don't send empty string!**

The consequences:

```json
{
  "timestamp": "2023-11-09T15:36:33.537+00:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/getAllSequenceElementsCount"
}
```

Feel free to use it!