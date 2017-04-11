/*
 * ViewerFrame.java
 *
 * Created on December 3, 2007, 2:26 PM
 *
 * Copyright (c) 2017, Datalogics, Inc. All rights reserved. 
 *
 * For complete copyright information, refer to:
 * http://dev.datalogics.com/adobe-pdf-library/license-for-downloaded-pdf-samples/
 */

package com.datalogics.PDFL.Samples;

import apple.dts.samplecode.osxadapter.OSXAdapter;
import java.awt.FileDialog;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;

import com.datalogics.PDFL.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 *
 * @author  jasonf
 */
@SuppressWarnings("serial")
public class ViewerFrame extends javax.swing.JFrame implements ActionListener, ItemListener, WindowListener {
    
    // non-IDE generator member variables:
	private Library library;
	private Document currentDoc = null;
	private int currentPage = 0;
    private String lastSearchTerm = null;
    private final  DisplayPDF displayPDF;
    
    // Check that we are on Mac OS X.  This is crucial to loading and using the OSXAdapter class.
    public static boolean MAC_OS_X = (System.getProperty("os.name").toLowerCase().startsWith("mac os x"));


    /** Creates new form ViewerFrame */
    public ViewerFrame() {
        library = new Library();
        displayPDF = new DisplayPDF();
        initComponents();
        jScrollPane1.setViewportView(displayPDF);

        registerForMacOSXEvents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainToolBar = new javax.swing.JToolBar();
        openToolbarButton = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        currentPageText = new javax.swing.JTextField();
        pageCountLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        zoomAmount = new javax.swing.JComboBox();
        btnZoomOut = new javax.swing.JButton();
        btnZoomIn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        searchText = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        printMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Display PDF");
        setMinimumSize(new java.awt.Dimension(450, 46));
        addWindowListener(this);

        mainToolBar.setRollover(true);

        openToolbarButton.setText("Open");
        openToolbarButton.setFocusable(false);
        openToolbarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openToolbarButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openToolbarButton.addActionListener(this);
        mainToolBar.add(openToolbarButton);

        btnPrint.setText("Print");
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(this);
        mainToolBar.add(btnPrint);
        mainToolBar.add(jSeparator2);

        btnFirst.setText("<<");
        btnFirst.setFocusable(false);
        btnFirst.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFirst.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFirst.addActionListener(this);
        mainToolBar.add(btnFirst);

        btnPrev.setText("<");
        btnPrev.setFocusable(false);
        btnPrev.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrev.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrev.addActionListener(this);
        mainToolBar.add(btnPrev);

        btnNext.setText(">");
        btnNext.setFocusable(false);
        btnNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNext.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNext.addActionListener(this);
        mainToolBar.add(btnNext);

        btnLast.setText(">>");
        btnLast.setFocusable(false);
        btnLast.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLast.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLast.addActionListener(this);
        mainToolBar.add(btnLast);

        currentPageText.setText("    ");
        currentPageText.setMaximumSize(new java.awt.Dimension(50, 2147483647));
        currentPageText.setMinimumSize(new java.awt.Dimension(50, 20));
        currentPageText.addActionListener(this);
        mainToolBar.add(currentPageText);

        pageCountLabel.setText(" ");
        pageCountLabel.setMaximumSize(new java.awt.Dimension(75, 14));
        pageCountLabel.setMinimumSize(new java.awt.Dimension(30, 14));
        pageCountLabel.setPreferredSize(new java.awt.Dimension(30, 14));
        mainToolBar.add(pageCountLabel);
        mainToolBar.add(jSeparator4);

        zoomAmount.setEditable(true);
        zoomAmount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10 %", "25 %", "50 %", "75 %", "100 %", "125 %", "150 %", "400 %", "800 %", "1600 %", "2400 %", "3200 %" }));
        zoomAmount.setSelectedItem("100 %");
        zoomAmount.setMaximumSize(new java.awt.Dimension(75, 32767));
        zoomAmount.setMinimumSize(new java.awt.Dimension(50, 18));
        zoomAmount.addItemListener(this);
        mainToolBar.add(zoomAmount);

        btnZoomOut.setText("-");
        btnZoomOut.setFocusable(false);
        btnZoomOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomOut.setMaximumSize(new java.awt.Dimension(20, 21));
        btnZoomOut.setMinimumSize(new java.awt.Dimension(20, 21));
        btnZoomOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnZoomOut.addActionListener(this);
        mainToolBar.add(btnZoomOut);

        btnZoomIn.setText("+");
        btnZoomIn.setFocusable(false);
        btnZoomIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomIn.setMaximumSize(new java.awt.Dimension(20, 21));
        btnZoomIn.setMinimumSize(new java.awt.Dimension(20, 21));
        btnZoomIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnZoomIn.addActionListener(this);
        mainToolBar.add(btnZoomIn);
        mainToolBar.add(jSeparator3);

        searchText.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        searchText.addActionListener(this);
        mainToolBar.add(searchText);

        btnSearch.setText("Search");
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(this);
        mainToolBar.add(btnSearch);

        getContentPane().add(mainToolBar, java.awt.BorderLayout.NORTH);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(550, 23));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(550, 502));
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setText("Open...");
        openMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);

        printMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        printMenuItem.setText("Print...");
        printMenuItem.addActionListener(this);
        fileMenu.add(printMenuItem);
        fileMenu.add(jSeparator1);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(this);
        fileMenu.add(exitMenuItem);

        mainMenuBar.add(fileMenu);

        setJMenuBar(mainMenuBar);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == openToolbarButton) {
            ViewerFrame.this.openActionPerformed(evt);
        }
        else if (evt.getSource() == btnPrint) {
            ViewerFrame.this.printActionPerformed(evt);
        }
        else if (evt.getSource() == btnFirst) {
            ViewerFrame.this.navigatePage(evt);
        }
        else if (evt.getSource() == btnPrev) {
            ViewerFrame.this.navigatePage(evt);
        }
        else if (evt.getSource() == btnNext) {
            ViewerFrame.this.navigatePage(evt);
        }
        else if (evt.getSource() == btnLast) {
            ViewerFrame.this.navigatePage(evt);
        }
        else if (evt.getSource() == currentPageText) {
            ViewerFrame.this.navigatePage(evt);
        }
        else if (evt.getSource() == btnZoomOut) {
            ViewerFrame.this.zoomActionPerformed(evt);
        }
        else if (evt.getSource() == btnZoomIn) {
            ViewerFrame.this.zoomActionPerformed(evt);
        }
        else if (evt.getSource() == searchText) {
            ViewerFrame.this.performSearch(evt);
        }
        else if (evt.getSource() == btnSearch) {
            ViewerFrame.this.performSearch(evt);
        }
        else if (evt.getSource() == openMenuItem) {
            ViewerFrame.this.openActionPerformed(evt);
        }
        else if (evt.getSource() == printMenuItem) {
            ViewerFrame.this.printActionPerformed(evt);
        }
        else if (evt.getSource() == exitMenuItem) {
            ViewerFrame.this.exitMenuItemActionPerformed(evt);
        }
    }

    public void itemStateChanged(java.awt.event.ItemEvent evt) {
        if (evt.getSource() == zoomAmount) {
            ViewerFrame.this.zoomAmountItemStateChanged(evt);
        }
    }

    public void windowActivated(java.awt.event.WindowEvent evt) {
    }

    public void windowClosed(java.awt.event.WindowEvent evt) {
    }

    public void windowClosing(java.awt.event.WindowEvent evt) {
        if (evt.getSource() == ViewerFrame.this) {
            ViewerFrame.this.formWindowClosing(evt);
        }
    }

    public void windowDeactivated(java.awt.event.WindowEvent evt) {
    }

    public void windowDeiconified(java.awt.event.WindowEvent evt) {
    }

    public void windowIconified(java.awt.event.WindowEvent evt) {
    }

    public void windowOpened(java.awt.event.WindowEvent evt) {
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
		// Create a file dialog.  FileDialog shows a native file open dialog
		// and tends to look nicer than a JFileChooser.
		FileDialog fd = new FileDialog(this, "Open", FileDialog.LOAD);
		
		// tell the dialog to only accept .pdf files
		fd.setFilenameFilter(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				int dotIndex = filename.lastIndexOf(".");
				if(dotIndex != -1) {
					String extension = filename.substring(filename.lastIndexOf("."));
					if (".pdf".equalsIgnoreCase(extension)) return true;
				}
				return false;
			}
		});
		fd.setVisible(true);
		if (fd.getFile() != null) {
			File f = new File(fd.getDirectory(), fd.getFile());
			currentDoc = new Document(f.getAbsolutePath());
			displayPDF.setDocument(currentDoc);
            goToPage(0);
            pageCountLabel.setText(" of " + currentDoc.getNumPages());
		}
    }//GEN-LAST:event_openActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
		PrintUserParams userParams = new PrintUserParams();
		if (userParams.posePrintDialog(currentDoc))
			currentDoc.print(userParams);
    }//GEN-LAST:event_printActionPerformed

    private void goToPage(final int pageNumber) {
		if (currentDoc == null || displayPDF == null) return;
		
		if (pageNumber < 0) return;
		if (pageNumber >= currentDoc.getNumPages()) return;
		
		currentPage = pageNumber;
        currentPageText.setText("" + (currentPage+1));
        new ProtectedOperation<Object>() {
            public Object doOperation() {
                displayPDF.displayPage(pageNumber);
                return null;
            }
        }.execute();
	}

    private abstract class ProtectedOperation<T> {
        public T execute() {
            do {
                try {
                    return this.doOperation();
                } catch (RuntimeException ex) {
                    String message = ex.getMessage();
                    if (!message.startsWith("PDF Library Error:"))
                        throw ex;

                    if (!message.contains("1073938472"))
                        throw ex;

                    if (!promptForPassword())
                        break;
                }
            } while (true);
            return null;
        }

        public abstract T doOperation();

        private boolean promptForPassword() {
            final JLabel passwordPrompt1 = new JLabel("The requested operation requires additional permissions.");
            final JLabel passwordPrompt2 = new JLabel("Please enter the document password.");
            final JPasswordField jpf = new JPasswordField();
            JOptionPane jop = new JOptionPane(new Object[] {passwordPrompt1, passwordPrompt2, jpf},
                    JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            JDialog dialog = jop.createDialog(ViewerFrame.this, "Password:");
            dialog.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    jpf.requestFocusInWindow();
                }
            });
            dialog.setVisible(true);
            int result = (Integer)jop.getValue();
            dialog.dispose();
            if (result == JOptionPane.OK_OPTION)
                return currentDoc.permRequest(new String(jpf.getPassword()), PermissionRequestOperation.ALL_OPERATIONS);

            return false;
        }

    }

    private void navigatePage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigatePage
        Object source = evt.getSource();
        if (source == btnFirst) {
            goToPage(0);
        } else if (source == btnLast) {
            if (currentDoc != null)
                goToPage(currentDoc.getNumPages() - 1);
        } else if (source == btnNext) {
            goToPage(currentPage + 1);
        } else if (source == btnPrev) {
            goToPage(currentPage - 1);
        } else if (source == currentPageText) {
            String pageString = currentPageText.getText();
            int newPage = -1;
            try {
                newPage = Integer.parseInt(pageString);
                goToPage(newPage - 1);
            } catch (NumberFormatException ex) {}
        }
    }//GEN-LAST:event_navigatePage

    private void setZoom(double newZoom) {
        double oldZoom = displayPDF.getZoom();
        
        if (newZoom < 0.10)
            newZoom = 0.10;
        if (newZoom > 32.0)
            newZoom = 32.0;
        
        displayPDF.setZoom(newZoom);
        try {
            final int pageNumber = currentPage;
            new ProtectedOperation<Object>() {
                public Object doOperation() {
                    displayPDF.displayPage(pageNumber);
                    return null;
                }
            }.execute();
            
            zoomAmount.getEditor().setItem(Integer.toString((int)(newZoom*100.0)) + " %");
        } catch (OutOfMemoryError ex) {
            displayPDF.setZoom(oldZoom);
            System.gc();
            // If an exception happens during an action, alert the user and attempt to continue.
			JOptionPane.showMessageDialog(this,
					ex.toString(),
					"An exception has occurred", 
					JOptionPane.ERROR_MESSAGE);

        }
    }
    
    private void zoomAmountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_zoomAmountItemStateChanged
        // we only care about selected events, not deselected events.
        if (evt.getStateChange() != java.awt.event.ItemEvent.SELECTED)
            return;
        
        // it should be a string, if not, something bizarre happened.
        Object o = evt.getItem();
        if (!(o instanceof String))
            return;
        
        String zoomString = (String)o;
        zoomString = zoomString.replaceAll("%", "");
        double zoom = 0.0;
        try {
            zoom = Double.parseDouble(zoomString);
            setZoom(zoom / 100.0);
        } catch (NumberFormatException ex) {}
}//GEN-LAST:event_zoomAmountItemStateChanged

    private void zoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomActionPerformed
        double currentZoom = displayPDF.getZoom();
        int i = 0, downIndex = 0;
        for (i = 0; i < zoomAmount.getItemCount(); i++) {
            String s = (String)zoomAmount.getItemAt(i);
            s = s.replaceAll("%", "");
            double d = Double.parseDouble(s);
            d = d / 100.0;
            if (d < currentZoom)
                downIndex = i;
            if (d > currentZoom)
                break;
        }
        if (i >= zoomAmount.getItemCount())
            return;
        
        if (evt.getSource() == btnZoomOut)
            zoomAmount.setSelectedIndex(downIndex);
        else if (evt.getSource() == btnZoomIn)
            zoomAmount.setSelectedIndex(i);
    }//GEN-LAST:event_zoomActionPerformed

    private void performSearch(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performSearch
        String searchTerm = searchText.getText();
        if (null == searchTerm || "".equals(searchTerm)) {
            displayPDF.clearHighlights(); // clear search
            displayPDF.repaint();
            return;
        }
        
        if (searchTerm.equals(lastSearchTerm))
            return; // same search, nothing to do.
        
        displayPDF.clearHighlights(); // clear search
        WordFinderConfig wfc = new WordFinderConfig();
        wfc.setIgnoreCharGaps(true);
        final WordFinder wf = new WordFinder(currentDoc, WordFinderVersion.LATEST, wfc);
        try {
            final java.util.ArrayList<Word> words =
                new ProtectedOperation<java.util.ArrayList<Word>>() {
                    public java.util.ArrayList<Word> doOperation() {
                        return new java.util.ArrayList<Word>(wf.getWordList(currentPage));
                    }
                }.execute();

            for (Word word : words) {
                String text = word.getText().toLowerCase(); // case insensitive search
                String lowerSearchTerm = searchTerm.toLowerCase();
                int characterIndex = 0;
                while ((characterIndex = text.indexOf(lowerSearchTerm, characterIndex)) != -1) {
                    final List<Quad> charQuads = word.getCharQuads();
                    Quad left = charQuads.get(characterIndex);
                    Quad right = charQuads.get(characterIndex+lowerSearchTerm.length()-1);
                    Quad highlightQuad = new Quad(left.getTopLeft(), right.getTopRight(), left.getBottomLeft(), right.getBottomRight());
                    displayPDF.addHighlight(highlightQuad);
                    characterIndex += lowerSearchTerm.length();
                }
            }
            displayPDF.repaint();
            
        } finally {
            wf.delete();
        }
    }//GEN-LAST:event_performSearch

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cleanup();
    }//GEN-LAST:event_formWindowClosing

    public void cleanup() {
        if (library != null)
            library.delete();
        library = null;
    }

    // Generic registration with the Mac OS X application menu
    // Checks the platform, then attempts to register with the Apple EAWT
    // See OSXAdapter.java to see how this is done without directly referencing any Apple APIs
    public void registerForMacOSXEvents() {
        if (MAC_OS_X) {
            try {
                // Generate and register the OSXAdapter, passing it a hash of all the methods we wish to
                // use as delegates for various com.apple.eawt.ApplicationListener methods
                OSXAdapter.setQuitHandler(this, getClass().getDeclaredMethod("quit", (Class[])null));
            } catch (Exception e) {
                System.err.println("Error while loading the OSXAdapter:");
                e.printStackTrace();
            }
        }
    }

    // General quit handler; fed to the OSXAdapter as the method to call when a system quit event occurs
    // A quit event is triggered by Cmd-Q, selecting Quit from the application or Dock menu, or logging out
    public boolean quit() {
        cleanup();
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnZoomIn;
    private javax.swing.JButton btnZoomOut;
    private javax.swing.JTextField currentPageText;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JToolBar mainToolBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JButton openToolbarButton;
    private javax.swing.JLabel pageCountLabel;
    private javax.swing.JMenuItem printMenuItem;
    private javax.swing.JTextField searchText;
    private javax.swing.JComboBox zoomAmount;
    // End of variables declaration//GEN-END:variables
    
}
