echo "{
  \"variants\": {
    \"facing=north\": {
      \"model\": \"santaniumdecorations:block/${1}_present\"
    },
    \"facing=east\": {
      \"model\": \"santaniumdecorations:block/${1}_present\",
      \"y\": 90
    },
    \"facing=south\": {
      \"model\": \"santaniumdecorations:block/${1}_present\",
      \"y\": 180
    },
    \"facing=west\": {
      \"model\": \"santaniumdecorations:block/${1}_present\",
      \"y\": 270
    }
  }
}" > "${1}_trap_present.json"
