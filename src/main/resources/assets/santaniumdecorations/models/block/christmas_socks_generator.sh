for ((i=0; i<3; i++))
do
  if [[ i -eq 0 ]]; then
    part="one"
  elif [[ i -eq 1 ]]; then
    part="two"
  elif [[ i -eq 2 ]]; then
    part="three"
  fi
  echo "{
  \"parent\": \"santaniumdecorations:block/template_christmas_socks_${part}\",
  \"textures\": {
    \"bottom\": \"minecraft:block/${1}_wool\"
  }
}" > "${1}_christmas_socks_${part}.json"
done
