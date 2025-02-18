https://x.com/i/grok?conversation=1891910743064289306
curl -X POST "http://localhost:8080/api/users/register" \
     -H "Content-Type: application/json" \
     -d '{
    "username":"user",
    "email":"user@company.com",
    "roles":"USER",
    "password":"password"
         }'
