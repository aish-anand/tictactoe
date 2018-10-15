How to build and test (from Terminal):
1. Install Apache Ant (skip to step 2 if you have Ant installed)
- Download the compressed binaries from [here](https://ant.apache.org/manualdownload.cgi). 
- Extract the compressed file into a directory structure of your choice. Set the `ANT_HOME` environment variable to this location and include the `ANT_HOME/bin` directory in your path.
- Run `ant -version` from command line to ensure installation is working as expected.

2. Clean and building project
`ant clean` - Cleaning deleted all generated files
`ant` - Run ant in the root directory, which contains the build.xml build file. Compiled java classes will be in the bin directory.

3. Running tests
`ant test` - to run all tests part of the project.

4.Running the project
`java -cp bin TicTacToe` from the root directory to run the project after building it.