for ((i=0; i<8; i++))
do
  if [[ i -eq 0 ]]; then
    part="bottom"
  elif [[ i -eq 1 ]]; then
    part="bottom_hinge"
  elif [[ i -eq 2 ]]; then
    part="bottom_open"
  elif [[ i -eq 3 ]]; then
    part="bottom_hinge_open"
  elif [[ i -eq 4 ]]; then
    part="top"
  elif [[ i -eq 5 ]]; then
    part="top_hinge"
  elif [[ i -eq 6 ]]; then
    part="top_open"
  elif [[ i -eq 7 ]]; then
    part="top_hinge_open"
  fi
  echo "{
  \"parent\": \"santaniumdecorations:block/template_wreath_door_${part}\",
  \"textures\": {
    \"top\": \"minecraft:block/${1}_door_top\",
    \"bottom\": \"minecraft:block/${1}_door_bottom\"
  }
}" > "wreath_${1}_door_${part}.json"
done
