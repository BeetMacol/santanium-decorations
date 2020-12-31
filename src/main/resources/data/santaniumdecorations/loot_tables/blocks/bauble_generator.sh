echo "{
  \"type\": \"minecraft:block\",
  \"pools\": [
    {
      \"rolls\": 1,
      \"entries\": [
        {
          \"type\": \"minecraft:item\",
          \"name\": \"santaniumdecorations:bauble_${1}\"
        }
      ],
      \"conditions\": [
        {
          \"condition\": \"minecraft:survives_explosion\"
        }
      ]
    }
  ]
}" > "bauble_${1}.json"
