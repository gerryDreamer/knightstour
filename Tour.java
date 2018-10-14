/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [2017] [Gerishom Muzembi]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s): Gerishom Muzembi (Gerry Dreamer Ventures)
 */
package knightstour;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author gerry
 */
public class Tour implements Runnable{
    private Integer chessBoard[][] = new Integer[8][8];
    private Boolean checkedBoard[][] = new Boolean[8][8];
    private int[] horizontal = {2,1,-1,-2,-2,-1,1,2};
    private int[] vertical = {-1,-2,-2,-1,1,2,2,1};
    private int currentRow=0;
    private int currentColumn=0;
    private int moveNumber;
    public Tour() {
        //init the board       
        //this.printBoard(chessBoard);
    }
    
    @Override
    public void run()
    {
          this.initializeBoard(chessBoard, 0);
          this.initializeBoard(checkedBoard, false);//init the checked boards
          int counter = 0;
          //sleep for 100 milliseconds in a loop counter of 0-64
         do{
              try
          {
              long duration = 10L;
              TimeUnit.MILLISECONDS.sleep(duration);
          }
          catch(InterruptedException e)
          {
              e.printStackTrace();
          }
              //program logic 
              //allow the program to determine the next move number based 
              //on whether the square has been accessed or a wall is to be hit
              //avoid the walls or accessed squares
              int finalSpot=0;
              try
              {
                 
                  //ensure that the final position has not been occupied and is within the bounds
                  if((finalSpot >= 0 && finalSpot < chessBoard.length) && (checkedBoard[currentRow][currentColumn] == false))
                  {
                      //use the final spot to determine the next move number
                     
                  }
                  //if the final spot is out of bounds
                   else
                  {
                      throw new ArrayIndexOutOfBoundsException();
                  }
                  
                 //make sure the current rows and columns are -ge 0 and -lt wallsize
                  //for the current row
                  if((currentRow >= 0 && currentRow < chessBoard.length))
                  {
                      
                  }
                  //the row is out of bounds               
                  else
                  {
                    throw new ArrayIndexOutOfBoundsException();//handle the problem in the catch  
                  }
                  
                  if(currentColumn >= 0  && currentColumn < chessBoard.length)
                  {
                      
                  }
                  //the column is out of bounds
                  else
                  {
                      throw new ArrayIndexOutOfBoundsException();
                  }               
                  
              }
              catch(ArrayIndexOutOfBoundsException e)
              {
                  
              }
              counter++;
         }
         while(counter < 10);
          this.printBoard(chessBoard); 
           this.printBoard(checkedBoard); 
    }
    
    private <T> void initializeBoard(T[][] board, T value)
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board.length; j++)
            {
                board[i][j] = value;
            }
        }
    }
    
     private <T> void printBoard(T[][] board)
    {
        System.out.println("\n\n");       
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board.length; j++)
            {
              System.out.printf("%s ",board[i][j]);
            }
            System.out.println();
        }
    }
     
      public static void main(String[] args)
    {
        Tour t = new Tour();
        Thread tourThread = new Thread(t);
        tourThread.start();
    }
}
