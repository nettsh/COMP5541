# COMP5541

## compiling

to compile, please `cd` to directory `GUI` and run the command `javac -cp ../:. *.java`.

# executing

to run the GUI, please `cd` to directory `GUI` and run the command `java -cp ../:. UI.java`.

# left to do
[x] eaten feature
   - the backend currently does not support eaten tags in the .csv file.
   - the frontend should be able to translate what is read by the back end into boolean displays in the GUI.

[x] add feature
   - the frontend should be able to read the user input and then call the backends write feature, subsequently a refresh feature on primary table display.

[x] delete
   - the front end should be able to extract the ID from the selected row and communicate with the backend to request a delete.
[ ] modify
   - the front end should call the delete feature, and an add feature right away.

[n/a] refresh
   - the app should compartmentalize a read function which clears the rows from the model table, and re-reads from the csv file.

[ ] unit testing
   - there should be unit tests across the backend. although not a deliverable, we should at least demonstrate that we practice testing.
