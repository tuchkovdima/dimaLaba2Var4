import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindTest
{
    @Test
    fun searchForAFileInTheMainInputFolderInRootAndAllDirectories()
    {
        val list = setOf("4.txt", "5.txt", "8.txt", "2.txt")
        assertEquals(Find().find("./input", true, listOf("4.txt", "5.txt", "8.txt", "2.txt")), list)
    }

    @Test
    fun searchForAFileInTheMainInputFolderInRoot()
    {
        val list = setOf("5.txt")
        assertEquals(Find().find("./input", false, listOf("5.txt")), list)
    }

    @Test
    fun searchForAFileInTheMainInputFolderNextTestSecondNextTestFiveAndAllDirectories()
    {
        val list = setOf("7.txt")
        assertEquals(Find().find("./input/TestSecond/TestFive", true, listOf("7.txt")), list)
    }

    @Test
    fun searchForAFileInTheMainInputFolderNextTestTreeeeAndAllDirectories()
    {
        val list = setOf("9.txt")
        assertEquals(Find().find("./input/TestTreeee/", true, listOf("9.txt")), list)
    }
}
