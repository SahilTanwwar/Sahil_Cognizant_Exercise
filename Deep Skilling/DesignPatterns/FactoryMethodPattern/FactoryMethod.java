import javax.print.Doc;

interface Document{
    void document();
}

class WordDocument implements  Document{
    public void document(){
        System.out.println("This is worddocument");
    }
}

class PdfDocument implements Document{
    public void document(){
        System.out.println("This is a pdf document");
    }
}

class Exceldocument implements Document{
    public  void document(){
        System.out.println("This is a Excel document");
    }
}

class DocFactory{
    public static Document getdoc(String type){
        if(type.equals("word")){
            return new WordDocument();
        }else if(type.equals("pdf")){
            return new PdfDocument();
        } else if(type.equals("excel")) {
            return new Exceldocument();
        }
        return null;
    }
}
class Main{
    public static void main(String[] args) {
        Document D1 = DocFactory.getdoc("word");
        D1.document();;
    }
}
