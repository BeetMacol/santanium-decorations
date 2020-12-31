echo "{
	\"type\": \"minecraft:crafting_shaped\",
	\"pattern\": [
		\" W \",
		\"WSW\",
		\" W \"
	],
	\"key\": {
		\"W\": {
			\"item\": \"minecraft:${1}_wool\"
		},
		\"S\": {
			\"item\": \"santaniumdecorations:santanium_ingot\"
		}
	},
	\"result\": {
		\"item\": \"santaniumdecorations:${1}_present\",
		\"count\": 1
	}
}" > "${1}_present.json"
