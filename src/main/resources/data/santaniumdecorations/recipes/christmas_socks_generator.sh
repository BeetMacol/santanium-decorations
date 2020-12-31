echo "{
  \"type\": \"minecraft:crafting_shapeless\",
  \"ingredients\": [
    {
      \"item\": \"minecraft:string\"
    },
    {
      \"item\": \"minecraft:${1}_wool\"
    },
    {
      \"item\": \"santaniumdecorations:santanium_ingot\"
    }
  ],
  \"result\": {
    \"item\": \"santaniumdecorations:${1}_christmas_socks\",
    \"count\": 2
  }
}" > "${1}_christmas_socks.json"
