# APCS-Adventure-Project
	This is our APCS Game.

How to Work This:
--------------

An Event is a single segment of text with it's resulting choices.

Each Event has it's own file, with id, title, body, and choices each with their destination ids choices with id of a different node will end the current event, id 99-99-99 will end the event chain.

id is formatted as follows: 

-[level]-[node]-[count]
title of each event file will be "Event_" plus the above
Example:
-[Event_3-4-3.txt] //file name
-3-4-3$ //id
-Rhapsody$ //title
-He tried but he failed //body
-He failed but he tried //body
-He ate his words, yes.$ //body
-find your friends$
-3-4-5$
-eat a cake$
-3-4-7$
-go back home$
-3-5-1$
Each MapMode object will call it's own list of node coordinates. 
MapModes are labeled by level,
-EventNodes by node,
-Events by count.
