Hey CS 578 Guys:

It's probably a huge stretch to assume that someone didn't figure out the badges
puzzle in about 30 seconds.  Purdue is a place full of smart people after all.

I wrote this program to brush up on Java after a long break (10 years or so since
my undergraduate degree).  My skills are SUPER rusty, so please no style whining.
Constructive comments on implementation or architecture are absolutely appreciated.

I figured I could push this to a public repository and others (if so motivated)
could contribute function proposals to look at the badges text file.  The code
uses a function registry to iterate over all added functions.  I wrote a simple
one that just guesses for my test implementation.  I'll probably implement a few
functions myself to see what I can learn about the data. 

FYI, I built this project in eclipse because I'm not a Java pro and it made it
easier to get started.  You could drop this folder structure into a project and
it should be good to go.  (or, you know, write a makefile)  

All you should have to do with respect to implementation is:

1. Create a class that implements FunctionIntf in the functions package.
2. Add a call to your constructor and add that function to the registry in the
importfunctions method in FunctionRegistry.java.

That's it.  You can run the code and see how you've compared with someone else.

Last thing - it would be good etiquette to create your own branch and test your
code before merging to master.  If you break code that currently builds in rude
fashion, we are unlikely to be friends and colleagues.  =)

-JHC