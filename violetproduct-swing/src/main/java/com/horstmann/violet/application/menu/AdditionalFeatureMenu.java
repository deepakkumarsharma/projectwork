package com.horstmann.violet.application.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.horstmann.violet.application.gui.MainFrame;
import com.horstmann.violet.framework.injection.resources.ResourceBundleInjector;
import com.horstmann.violet.framework.injection.resources.annotation.ResourceBundleBean;
import com.horstmann.violet.product.diagram.abstracts.AbstractGraph;
import com.horstmann.violet.product.diagram.classes.node.ClassNode;


@ResourceBundleBean(resourceReference = MenuFactory.class)
public class AdditionalFeatureMenu extends JMenu
{

   @ResourceBundleBean(key = "additional")
   public AdditionalFeatureMenu(final MainFrame mainFrame)
   {
       ResourceBundleInjector.getInjector().inject(this);
       this.mainFrame = mainFrame;
       this.createMenu();
   }
   private void createMenu()
   {     
       featureOneEnable.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent event)
           {
               if (isThereAnyWorkspaceDisplayed()) {
            	   AbstractGraph.feature1enabled = true;
               }
           }
       });
       this.add(featureOneEnable);
 
       featureOneDisable.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent event)
           {
               if (isThereAnyWorkspaceDisplayed()) {
            	   AbstractGraph.feature1enabled = false;
               }
           }
       });
       this.add(featureOneDisable);       

       featureTwoEnable.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent event)
           {
               if (isThereAnyWorkspaceDisplayed()) {
            	   AbstractGraph.feature2enabled = true;
               }
           }
       });
       this.add(featureTwoEnable);
       
       featureTwoDisable.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent event)
           {
               if (isThereAnyWorkspaceDisplayed()) {
            	   AbstractGraph.feature2enabled = false;
               }
           }
       });
       this.add(featureTwoDisable);    

       calculateCBO.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent event)
           {
               if (isThereAnyWorkspaceDisplayed()) {
            	  ClassNode.CBOenabled = true;
               }
           }
       });
       this.add(calculateCBO);    
       
   }

   private boolean isThereAnyWorkspaceDisplayed()
   {
       return mainFrame.getWorkspaceList().size() > 0;
   }
   
   /** Application frame */
   private MainFrame mainFrame;

   @ResourceBundleBean(key = "additional.featureoneenable")
   private JMenuItem featureOneEnable;

   @ResourceBundleBean(key = "additional.featureonedisable")
   private JMenuItem featureOneDisable;

   @ResourceBundleBean(key = "additional.featuretwoenable")
   private JMenuItem featureTwoEnable;

   @ResourceBundleBean(key = "additional.featuretwodisable")
   private JMenuItem featureTwoDisable;

   @ResourceBundleBean(key = "additional.calculate_CBO")
   private JMenuItem calculateCBO;
}