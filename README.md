# Decathlon web calculator

### Running locally
When launched locally:

* back-end: http://localhost:8080/total-score
* front-end: `<PROJECT_ROOT>/front-end/decathlon.html`

Sample curl for testing:
```
curl -i -H "Accept: application/json" "Content-Type:application/json" -X POST --data '[{"event": "METRES_100", "score": "10.46"}]' "http://localhost:8080/total-score"
```