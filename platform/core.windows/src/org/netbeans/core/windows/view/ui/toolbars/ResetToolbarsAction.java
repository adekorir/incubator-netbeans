/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.core.windows.view.ui.toolbars;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import org.openide.awt.ToolbarPool;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;

/**
 *
 * @author S. Aubrecht
 */
public class ResetToolbarsAction extends AbstractAction {
    
    /** Creates a new instance of ResetToolbarsAction */
    public ResetToolbarsAction() {
        super( NbBundle.getMessage(ResetToolbarsAction.class, "CTL_ResetToolbarsAction") ); //NOI18N
    }

    public void actionPerformed(ActionEvent e) {
        String name = ToolbarPool.getDefault().getConfiguration();
        FileObject fo = FileUtil.getConfigFile( "Toolbars" ); //NOI18N
        try {
            fo.revert();
        } catch (IOException ex) {
            Logger.getLogger(ResetToolbarsAction.class.getName()).log( Level.FINE, null, ex );
        }
        ToolbarPool.getDefault().waitFinished();
        ToolbarPool.getDefault().setConfiguration(name);
    }
    
}
