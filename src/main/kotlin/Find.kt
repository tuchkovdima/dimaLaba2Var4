import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

class Find
{
    fun find(directory: String, subdirectory: Boolean, fileNames: List<String>): Set<String>
    {
        val output = mutableSetOf<String>()

        if (!Files.exists(Path.of(directory))) throw IOException("Директории нет")

        if (!subdirectory)
        {
            for (file in fileNames.toSet())
            {
                if (Files.exists(Path.of(directory).resolve(file)))
                {
                    output.add(file)
                }
            }
        }
        else
        {
            val fileTree = PriorityQueue<File>()
            fileTree.addAll(File(directory).listFiles()!!)
            while (!fileTree.isEmpty())
            {
                val currentFile = fileTree.remove()
                if (currentFile.isDirectory)
                {
                    fileTree.addAll(currentFile.listFiles()!!)
                }
                else
                {
                    if (fileNames.toSet().contains(currentFile.name))
                    {
                        output.add(currentFile.name)
                    }
                }
            }
        }

        if (output.isEmpty())
        {
            println("Файлы не найдены!")
        }
        else
        {
            println(output)
        }
        return output
    }
}
