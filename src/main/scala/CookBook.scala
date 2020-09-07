import java.io.FileWriter

object CookBook extends App{
  val srcName = "C:/Users/User/CBook/CBook.txt"
  val dstName = "C:/Users/User/CBook/result.txt"
  def openSource(fName:String) = {
    val filePointer = scala.io.Source.fromFile(srcName)
    val myLines = filePointer.getLines.toSeq

    filePointer.close()
    myLines
  }
  def processSeq(mySeq:Seq[String])= {

    mySeq.filter(_.startsWith("    "))

  }


  def saveSeq(dstName:String, mySeq:Seq[String]) = {
    println(s"Saving my Sequence to file $dstName")
    mySeq.foreach(println)
    val fw = new FileWriter(dstName)
    mySeq.map(_ + "\n").foreach(fw.write)
    fw.close()
  }

  val mySeq = openSource(srcName)
  val filteredSeq = processSeq(mySeq)
  saveSeq(dstName,filteredSeq)
}
