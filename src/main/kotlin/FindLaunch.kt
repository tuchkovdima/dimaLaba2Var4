import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option

class FindLaunch : Exception()
{
    @Argument(required = true, metaVar = "FileName")
    private val fileNames: List<String>? = null

    @Option(name = "-d", metaVar = "directory")
    private val directory: String = System.getProperty("user.dir")

    @Option(name = "-r", metaVar = "subdirectory")
    private val subdirectory: Boolean = false
    fun launch(args: Array<String>)
    {
        val parser = CmdLineParser(this)
        try
        {
            parser.parseArgument(*args)
        }
        catch (e: CmdLineException)
        {
            System.err.println(e.message)
            System.err.println("Пример: java -jar ./build/libs/dimaLaba2Var4-1.0-SNAPSHOT.jar -r 4.txt")
            parser.printUsage(System.err)
            return
        }
            Find().find(directory!!, subdirectory, fileNames!!)

    }
}


