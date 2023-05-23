package Udemy;

import java.util.*;

public class Graphs {
    public static void main(String[] args) {
        //List<int[]> graph = GetAdjacencyList();
        //PrintAdjacencyList(graph);
        //System.out.println(AdjacencyListTraversalBFS(graph));
        /*int[][] matrix =
                {
                        {0, 1, 0, 1, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0}
                };*/
        //GetAdjacencyMatrix(9,9);
        //List<Integer> values = new ArrayList<>();
        //AdjacencyListTraversalDFS(0, graph, values, new boolean[graph.size()]);
        //AdjacencyMatrixTraversalDFS(0, matrix, values, new boolean[matrix.length]);
        //int[] managers = {2, 2, 4, 6, -1, 4, 4, 5};
        //int[] informTime = {0, 0, 4, 0, 7, 3, 6, 0};
        //TimeNeededToInformEmployees(8, 4, managers, informTime);
        //int[][] prereq = {{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};
        //int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        //int[][] trust ={{1,10},{10,2},{3,10},{10,4},{10,5},{10,6},{10,7},{8,10},{9,10},{10,11},{12,10}};
        //int[][] trust ={{1,2},{2,3},{4,2}};
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        //System.out.println(findJudge(3, trust));
        // System.out.println(findCenter(trust));
        //System.out.println(CourseScheduler(6, prereq));
        validPath(4, edges, 0, 3);
    }



    public static boolean validPath(int n, int[][] edges, int begin, int end) {
        if (n == 1) return true;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] currEdge = edges[i];
            int source = currEdge[0];
            int target = currEdge[1];
            graph[source].add(target);
            graph[target].add(source);
        }
        ArrayList<Integer> v = graph[begin];
        boolean[] seen = new boolean[n];
        seen[begin] = true;
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(v);
        while (queue.size() > 0) {
            ArrayList<Integer> currVertex = queue.poll();
            for (int ii = 0; ii < currVertex.size(); ii++) {
                int ss = currVertex.get(ii);
                if (ss == end)
                    return true;
                if (!seen[ss]) {
                    queue.add(graph[ss]);
                    seen[ss] = true;
                }
            }
        }
        return false;
    }

    public static int findCenter(int[][] edges) {
        int[] graphS = new int[edges.length + 1];
        int[] graphT = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int source = edge[0];
            int target = edge[1];
            graphS[source - 1]++;
            graphT[target - 1]++;
        }
        int max = graphS[0] + graphT[0];
        int index = 0;
        for (int i = 0; i < graphS.length; i++)
            if (max < graphS[i] + graphT[i]) {
                max = graphS[i] + graphT[i];
                index = i;
            }
        return index + 1;
    }

    static int findJudge(int n, int[][] trust) {
        int[] persons = new int[n];
        boolean[] trustees = new boolean[n];
        for (int i = 0; i < trust.length; i++) {
            int[] currentTrust = trust[i];
            int trustee = currentTrust[0];
            trustees[trustee - 1] = true;
            int whomtotrust = currentTrust[1];
            persons[whomtotrust - 1]++;
        }
        boolean noJudge = true;
        for (int i = 0; i < trustees.length; i++)
            if (!trustees[i]) {
                noJudge = false;
                break;
            }
        if (noJudge) return -1;
        for (int i = 0; i < persons.length; i++)
            if (persons[i] == n - 1) return i + 1;
        return -1;
    }

    static int[] CourseScheduler(int n, int[][] prereq) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] courses = new int[n];
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prereq.length; i++) {
            int[] currPrereqs = prereq[i];
            int courseId = currPrereqs[1];
            int pre = currPrereqs[0];
            inDegree[currPrereqs[0]]++;
            graph[courseId].add(pre);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0) stack.add(i);

        int count = 0;
        while (stack.size() > 0) {
            int currIndegree = stack.pop();
            courses[count] = currIndegree;
            count++;
            ArrayList<Integer> adjList = graph[currIndegree];
            for (int j = 0; j < adjList.size(); j++) {
                inDegree[adjList.get(j)]--;
                if (inDegree[adjList.get(j)] == 0) stack.add(adjList.get(j));
            }
        }
        if (count == n) return courses;
        int[] cc = {};
        return cc;
    }

    static void TimeNeededToInformEmployees(int n, int headId, int[] managers, int[] informTime) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> subs = new ArrayList<>();
            for (int j = 0; j < managers.length; j++) {
                if (i == managers[j])
                    subs.add(j);
            }
            //int[] subsArray = new int[subs.size()];
            list.add(subs);
        }


        boolean[] seen = new boolean[n];
        int time = 0;
        time = InformEmployeesDFS(list, informTime, headId);
        System.out.println(time);
    }

    private static int InformEmployeesDFS(List<List<Integer>> list, int[] informTime, int currentId) {
        List<Integer> subs = list.get(currentId);
        if (subs.size() == 0) return 0;
        int max = 0;
        for (int v = 0; v < subs.size(); v++) {
            max = Math.max(max, InformEmployeesDFS(list, informTime, subs.get(v)));
        }
        return max + informTime[currentId];
    }

    static void PrintAdjacencyList(List<int[]> graph) {
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).length; j++)
                System.out.print(graph.get(i)[j] + " ");
            System.out.println();
        }
    }

    static List<int[]> GetAdjacencyList() {
        List<int[]> list = new ArrayList<>() {
        };
        list.add(new int[]{1, 3});
        list.add(new int[]{0});
        list.add(new int[]{3, 8});
        list.add(new int[]{0, 2, 4, 5});
        list.add(new int[]{3, 6});
        list.add(new int[]{3});
        list.add(new int[]{4, 7});
        list.add(new int[]{6});
        list.add(new int[]{2});
        return list;
    }

    static int[][] GetAdjacencyMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        Random random = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = random.nextInt(2);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    static List<Integer> AdjacencyListTraversalBFS(int[][] graph) {
        boolean[] seen = new boolean[graph.length];
        List<Integer> values = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>() {
        };
        queue.add(0);

        while (queue.size() > 0) {
            int vertex = queue.poll();

            values.add(vertex);
            seen[vertex] = true;

            int[] connections = graph[vertex];
            for (int i = 0; i < connections.length; i++) {
                int connection = connections[i];
                if (connection >= 0 && !seen[connection])
                    queue.add(connection);
            }
        }
        return values;
    }

    static void AdjacencyListTraversalDFS(int vertex, List<int[]> graph, List<Integer> values, boolean[] seen) {
        values.add(vertex);
        seen[vertex] = true;

        int[] connections = graph.get(vertex);
        for (int i = 0; i < connections.length; i++) {
            int connection = connections[i];
            if (!seen[connection])
                AdjacencyListTraversalDFS(connection, graph, values, seen);
        }
    }

    static void AdjacencyMatrixTraversalDFS(int vertex, int[][] graph, List<Integer> values, boolean[] seen) {
        values.add(vertex);
        seen[vertex] = true;

        int[] connections = graph[vertex];
        for (int v = 0; v < connections.length; v++) {
            if (connections[v] > 0 && !seen[v])
                AdjacencyMatrixTraversalDFS(v, graph, values, seen);
        }
    }

    static List<Integer> AdjacencyMatrixTraversalBFS(int[][] graph) {
        boolean[] seen = new boolean[graph.length];
        List<Integer> values = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>() {
        };
        queue.add(0);

        while (queue.size() > 0) {
            int vertex = queue.poll();

            values.add(vertex);
            seen[vertex] = true;

            int[] connections = graph[vertex];
            for (int v = 0; v < connections.length; v++) {
                if (connections[v] > 0 && !seen[v])
                    queue.add(v);
            }
        }
        return values;
    }
}
