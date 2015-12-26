package hackerrank.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GrecherPlaySolution {
    static Map<Integer,Integer> actorScene=new HashMap<>();
    static Map<Integer,Integer> sceneActor=new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numberOfScenes=scanner.nextInt();
        int numberOfActors=scanner.nextInt();

        for(int i=0;i<numberOfScenes;i++){
            sceneActor.put(i,0);
        }
        int numberOfActions=scanner.nextInt();

        for(int i=0;i<numberOfActors;i++){
            int position=scanner.nextInt();
            Integer currentAllocaiton=actorScene.get(position);
            Integer sceneCurrentAllocation=sceneActor.get(position);
            if(currentAllocaiton==null) {
                currentAllocaiton=0;
            }
            if(sceneCurrentAllocation==null){
                sceneCurrentAllocation=0;
            }
            actorScene.put(i,position+currentAllocaiton);
            sceneCurrentAllocation++;
            sceneActor.put(position, sceneCurrentAllocation);
        }



        for(int i=0;i<numberOfActions;i++){
            int actionCode=scanner.nextInt();
            if(actionCode==2){
                System.out.println(actorScene);
                System.out.println(sceneActor);
                int threshold=scanner.nextInt();
                int count=0;
                for(Map.Entry<Integer,Integer> entry:sceneActor.entrySet()){
                    if(entry.getValue()<threshold){
                        count=count+1;
                    }
                }
                System.out.println(count);
            }else {
                int removeFromScene=scanner.nextInt();
                int addToScene=scanner.nextInt();
                int sceneOfActor= actorScene.get(removeFromScene);
                int currentScene=sceneActor.get(sceneOfActor);
                sceneActor.put(sceneOfActor,currentScene-1);
                currentScene=sceneActor.get(addToScene);
                sceneActor.put(addToScene,currentScene+1);
                System.out.println(actorScene);
                System.out.println(sceneActor);
            }
        }

    }
}
