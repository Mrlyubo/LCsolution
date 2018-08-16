import java.util.*;

/*
*   1. Using HashMap<String, TreeSet<String>> to store dictionary.
*   2. Using HashMap<String, List<String>> to save content.
*   3.
 */

public class FileSystem {
    private Map<String, TreeSet<String>> structure;
    private Map<String, List<String>> files;
    String root = "/";
    String start = "";

    public FileSystem() {
        structure = new HashMap<>();
        files = new HashMap<>();
        structure.put(root,new TreeSet<>());

    }

    public List<String> ls(String path) {
        List<String> list = new ArrayList<>();
        if(structure.containsKey(path)){//If it is a directory path, return the list of file and directory names in this directory
            list.addAll(structure.get(path));
            return list;
        }else if(files.containsKey(path)) { //If it is a file path, return a list that only contains this file's name
            list.add(path.substring(path.lastIndexOf("/")+1));
            return list;
        }else
            return list;
    }

    public void mkdir(String path) { //
        start = "";
        String[] elements = path.split("/");
        int index = 0;
        TreeSet<String> children;
        while ((index+1) < elements.length){
            if(index == 0) {
                structure.putIfAbsent(root, new TreeSet<>());
                children = structure.get(root);
            } else {
                structure.putIfAbsent(start, new TreeSet<>());
                children = structure.get(start);
            }
            children.add(elements[index+1]);
            start += (root+elements[index+1]);// create every root in the content.
            index++;
        }
    }

    public void addContentToFile(String filePath, String content) {
        mkdir(filePath);
        files.putIfAbsent(filePath, new ArrayList<>());
        List<String> contents = files.get(filePath);
        contents.add(content);
    }

    public String readContentFromFile(String filePath) {
        List<String> fileContent = files.get(filePath);
        StringBuilder sb = new StringBuilder();
        for(String word: fileContent){
            sb.append(word);
        }
        return sb.toString();
    }

    public static void main (String[] args) {
//        FileSystem fs = new FileSystem();
//        System.out.println(fs.ls("/"));//[]
//        fs.mkdir("/a/b/c");//null
//        fs.addContentToFile("/a/b/c/d", "hello");//create
//        fs.addContentToFile("/aa","hi");
//        System.out.println(fs.readContentFromFile("/a/b/c/d"));//"hello"
//        System.out.println(fs.ls("/a"));// b
//        System.out.println(fs.readContentFromFile("/a/b/c/d"));//"hello"
//

        FileSystem fs1 = new FileSystem();

        fs1.mkdir("/goowmfn");//null
        System.out.println(fs1.ls("/goowmfn"));//[null]
        System.out.println(fs1.ls("/"));//[/goowmfn]
        fs1.mkdir("/z");//null
        System.out.println(fs1.ls("/"));//[z ,goowmfn]
        fs1.addContentToFile("/goowmfn/c","shetopcy");
        System.out.println(fs1.ls("/z"));//[]
        System.out.println(fs1.ls("/goowmfn/c"));//["shetopcy"]
        System.out.println(fs1.ls("/goowmfn"));//["shetopcy"]
    }
}
//["FileSystem", "mkdir",     "ls","ls","mkdir" ,"ls", "ls", "addContentToFile","ls","ls","ls"]
//[[],["/goowmfn"],["/goowmfn"],["/"], ["/z"],  ["/"],["/"],["/goowmfn/c","shetopcy"],["/z"],["/goowmfn/c"],["/goowmfn"]]

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

