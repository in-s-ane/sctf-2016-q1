#!/bin/bash

initial=$(cat $1)
simplified=$(echo $initial |
    sed "s/true/True/g" |
    sed "s/false/False/g" |
    sed "s/!!//g" |
    sed "s/<->/==/g" |
    sed "s/&&/|_and_|/g" |
    sed "s/||/|_or_|/g" |
    sed "s/!true/False/gI" |
    sed "s/!false/True/gI" |
    sed "s/!(/Not(/g" |
    sed "s/!\(\w\)/Not(\1)/g" |
    sed "s/->/|implies|/g" |
    sed "s/|implies| not/|implies_not|/g"
)
echo "$simplified"
