#!/bin/bash
gnuplot --persist << EOF
plot "output3-roulette.txt" using 1:2 w p smooth bezier title "Metoda ruletki", "output3-tournament.txt" using 1:2 w p smooth bezier title "Metoda turniejowa"
exit
EOF
