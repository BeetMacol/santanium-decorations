echo "{
  \"type\": \"minecraft:crafting_shapeless\",
  \"ingredients\": [
    {
      \"item\": \"santaniumdecorations:${1}_present\"
    },
    {
      \"item\": \"minecraft:tnt\"
    },
    {
      \"item\": \"minecraft:tripwire_hook\"
    }
  ],
  \"result\": {
    \"item\": \"santaniumdecorations:${1}_trap_present\",
    \"count\": 1
  }
}" > "${1}_trap_present.json"
