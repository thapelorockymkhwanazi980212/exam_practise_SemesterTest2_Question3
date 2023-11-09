
package exam_practise_semestertest2_question3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;
import za.ac.tut.bl.AssetsManager;
import za.ac.tut.entity.Asset;

/**
 *
 * @author Thapelo Mkhwanazi
 */
public class Exam_practise_SemesterTest2_Question3
{

    public static void main(String[] args) throws IOException 
    {
        int choice;
        AssetsManager am = new AssetsManager();
        Asset asset;
        Map<Integer, Asset> assets = new HashMap<>();
        File file = new File("Assets.txt");
        
        choice = menu();
        
        while(choice != 4)
        {
            switch(choice)
            {
                case 1:
                    
                    int assetNo = getAssetNumber();
                    asset = getAssetDetails();
 
                    am.add(assetNo, asset, assets);
                    JOptionPane.showMessageDialog(null, "Asset added successfully to a Map!!!!");
                    
                    break;
                    
                case 2:
                    
                    am.store(assets, file);
                    JOptionPane.showMessageDialog(null, "Asset stored successfully in a file: "+  file.getName());
                    
                    break;
                    
                case 3:
                    
                    am.getAssets(file);
                    displayAssets(assets);
                    break;
                    
                default:
                    System.out.println(choice + " is not valid, please enter 1, 2, or 3");
            }
            
            choice = menu();
        }
        
    }

    private static int menu() 
    {
       Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the following\n-------------\n" + 
                "1. Add an asset to a Map\n" + 
                "2. Store the Map entries to a file\n" + 
                "3. Read the Map entries from the text file and display them\n" +
                "4. Exit the application");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        
        return choice;
       
    }
    
    private static Asset getAssetDetails()
    {
        String serialNo, description;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Asset SERIAL NUMBER");
        serialNo = sc.next();
        
        System.out.println("Enter asset DESCRIPTION");
        description = sc.next();
        
        Asset asset = new Asset();
        asset.setSerialNo(serialNo);
        asset.setSerialNo(description);
        
        return asset;
    }
    
    private static int getAssetNumber()
    {
         Scanner sc = new Scanner(System.in);
         System.out.println("Please enter asset number");
         int assetNo = sc.nextInt();
         
         return assetNo;
    }

    private static void displayAssets(Map<Integer, Asset> assets)
    {
        for(Map.Entry<Integer, Asset> entry :  assets.entrySet())
        {
            Integer key = entry.getKey();
            Asset asset = entry.getValue();
            
            System.out.println("\nAsset number: " + key + "\n" + 
                    "Serial number: " + asset.getSerialNo() + "\n" + 
                    "Description: " +  asset.getDescription());
        }
    }
    
}
