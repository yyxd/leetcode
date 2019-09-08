package acmcoder;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Diane on 2019-09-06.
 * Goal:
 */
class Directory implements Comparable<Directory> {
    String name;
    Directory[] dirs;
    File[] files;

    public Directory(String name) {
        this.name = name;
        dirs = new Directory[0];
        files = new File[0];
    }

    public Directory(String name, Directory[] dirs, File[] files) {
        this.name = name;
        this.dirs = dirs;
        this.files = files;
    }

    public Directory[] getDirs() {
        return dirs;
    }

    public void setDirs(Directory[] dirs) {
        this.dirs = dirs;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    @Override
    public int compareTo(Directory o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Directory)
            return this.name.equals(((Directory) obj).name);
        return false;
    }
}

class File implements Comparable<File> {
    String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(File o) {
        return this.name.compareTo(o.name);
    }
}

public class Compare2Dir {
    /**
     * 递归版本
     *
     * @param A
     * @param B
     * @return 相同的文件夹/文件数目
     */
    public int getSimilarCountWithRecursive(Directory A, Directory B) {
        // 对当前层做判断
        Directory[] ADirs = A.dirs;
        Directory[] BDirs = B.dirs;
        Arrays.sort(ADirs);
        Arrays.sort(BDirs);
        int i = 0, j = 0;
        int ans = 0;
        while (i < ADirs.length && j < BDirs.length) {
            if (ADirs[i].equals(BDirs[j])) {
                // 如果一致，则认为当前层有一个相同节点，然后再去递归比较子节点
                ans++;
                i++;
                j++;
                ans += getSimilarCountWithRecursive(ADirs[i], BDirs[i]);
            } else if (ADirs[i].compareTo(BDirs[j]) < 0)
                i++;
            else
                j++;
        }
        File[] AFiles = A.files;
        File[] BFiles = B.files;
        int res = compare2Files(AFiles, BFiles);
        ans += res;
        return ans;
    }

    /**
     * bfs 版本
     *
     * @param A
     * @param B
     * @return 相同的文件夹/文件数目
     */
    public int getSimilarCountWithBFS(Directory A, Directory B) {

        Queue<Pair<Directory, Directory>> compareQueue = new LinkedList<>();
        int ans = 0;
        // 将根目录放入，初始化queue
        compareQueue.offer(new Pair<>(A, B));
        while (!compareQueue.isEmpty()) {
            Pair<Directory, Directory> cur = compareQueue.poll();
            // 比较文件夹节点的相似性
            Directory[] ADirs = cur.getKey().dirs;
            Directory[] BDirs = cur.getValue().dirs;
            Arrays.sort(ADirs);
            Arrays.sort(BDirs);
            int i = 0, j = 0;
            while (i < ADirs.length && j < BDirs.length) {
                if (ADirs[i].equals(BDirs[j])) {
                    // 如果一致，则认为当前层有一个相同节点，然后将相同节点放到queue中继续比较
                    ans++;
                    compareQueue.offer(new Pair<>(ADirs[i], BDirs[j]));
                    i++;
                    j++;
                } else if (ADirs[i].compareTo(BDirs[j]) < 0)
                    i++;
                else
                    j++;
            }
            // 比较文件节点的相似性
            File[] AFiles = cur.getKey().files;
            File[] BFiles = cur.getValue().files;
            int res = compare2Files(AFiles, BFiles);
            ans += res;
        }
        return ans;
    }

    // 比较文件节点的相似性，先排序再比较
    public int compare2Files(File[] AFiles, File[] BFiles) {
        int res = 0;
        Arrays.sort(AFiles);
        Arrays.sort(BFiles);
        int p = 0, q = 0;
        while (p < AFiles.length && q < BFiles.length) {
            if (AFiles[p].compareTo(BFiles[q]) == 0) {
                res++;
                p++;
                q++;
            } else if (AFiles[p].compareTo(BFiles[q]) < 0)
                p++;
            else
                q++;
        }
        return res;
    }

    public static void main(String[] args) {
        Compare2Dir dirComparator = new Compare2Dir();
        // 测试用例1 ,比较两个空文件夹 目标结果为0
        Directory A = new Directory("A");
        Directory B = new Directory("B");
        System.out.println(dirComparator.getSimilarCountWithRecursive(A, B));
        System.out.println(dirComparator.getSimilarCountWithBFS(A, B));

        //测试用例2，比较两个不为空的文件夹
        //A((D1(DF1),D2){F1,F2})
        //B((D1(DF2),D3),{F1,F3})

        Directory A2 = new Directory("A");
        Directory B2 = new Directory("B");

        // 等于比较只有文件夹的文件夹
        File[] F1s = {new File("F1"), new File("F2")};
        File[] F2s = {new File("F1"), new File("F3")};
        A2.files = F1s;
        B2.files = F2s;

        // 注释掉一下的内容，等于比较一个只有Files 的文件夹
        File[] AD1Fs = {new File("DF1")};
        File[] BD1Fs = {new File("DF2")};
        Directory AD1 = new Directory("D1");
        Directory BD1 = new Directory("D1");
        AD1.setFiles(AD1Fs);
        BD1.setFiles(BD1Fs);
        Directory[] ADs = {AD1, new Directory("D2")};
        Directory[] BDs = {BD1, new Directory("D3")};

        A2.setDirs(ADs);
        B2.setDirs(BDs);
        System.out.println(dirComparator.getSimilarCountWithRecursive(A2, B2));
        System.out.println(dirComparator.getSimilarCountWithBFS(A2, B2));
    }
}
