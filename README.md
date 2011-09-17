gTwitter
========

Some time ago a colleague remarked to me how its common for Ruby enthusiasts to use TDD during presentations while the same thing does not happen nearly as much in the Java world. This is a shame because these people are in an important position to help shape the level of professionalism we can expect from the Java community and yet they do not give the right example.

In an attempt to remedy this I decided to try my hand at technologies while using TDD.
To start with I have chosen Grails and Twitter because haven't we all seen so many technologies that let you build a basic Twitter clone really fast?

This exercise took a little under a regular 8 hour working day and touches upon almost the entire stack of the Grails framework. There is GUI work, controller work, business- and data layer work. So it's not like a TDD approach will leave you stranded in boiler plate purgatory for long periods or anything.

Next up I'm thinking of making some screencasts to show the more interesting parts as the application takes shape.

If you would like to provide some feedback or have questions feel free to message me here on github or on twitter <a href="http://twitter.com/sebastiangozin">@sebastiangozin</a>

Usage
-----

* Download and install <a href="http://grails.org">grails-1.3.x</a>
* clone this repository
* $ grails test-app -coverage
* $ grails run-app

Features
--------

* register a new bird (no verification)
* signing in as a bird (no authentication)
* authorisation in order to be able to tweet
* displaying tweets per bird

Additional Notes
----------------

* 100% line coverage
* 83% branch coverage
* little under a normal working day's work
* deliverables were available every 45 mins (the length of my train commute)
* a fully featured in-memory implementation for test purposes
* a fully featured hibernate implementation
* a test suite under 2s
* a presentable web gui

