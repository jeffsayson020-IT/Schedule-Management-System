package schedule;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class FindMyClassroom extends JFrame {

    // =====================================
    // 1. SCHOOL COLOR THEME
    // =====================================

    static final Color NAVY = new Color(23, 54, 93);
    static final Color BLUE = new Color(40, 120, 200);
    static final Color GOLD = new Color(242, 193, 78);
    static final Color LIGHT = new Color(244, 247, 251);
    static final Color WHITE = Color.WHITE;
    static final Color DARK = new Color(40, 50, 65);
    static final Color GREEN = new Color(46, 139, 87);
    static final Color RED = new Color(190, 65, 65);

    // =====================================
    // 2. SCHEDULE DATA
    // =====================================

    static class Schedule {

        String subject;
        String teacher;
        String section;
        String time;
        String room;

        Schedule(String subject, String teacher,
                 String section, String time, String room) {

            this.subject = subject;
            this.teacher = teacher;
            this.section = section;
            this.time = time;
            this.room = room;
        }
    }

    static ArrayList<Schedule> schedules = new ArrayList<>();

    // ADMIN ACCOUNT
    static final String ADMIN_USERNAME = "admin";
    static final String ADMIN_PASSWORD = "1234";

    // =====================================
    // 3. CONSTRUCTOR
    // =====================================

    FindMyClassroom() {
    setTitle("Find My Classroom System");
    setSize(900, 600);
    setMinimumSize(new Dimension(700, 500));
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {

            int choice = JOptionPane.showConfirmDialog(
                FindMyClassroom.this,
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    });
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    addSampleSchedules();

    welcomeScreen();

    setVisible(true);
}

    // =====================================
    // 4. BUTTON DESIGN - FIXED VISIBILITY
    // =====================================

    JButton createButton(String text, Color color) {

        JButton button = new JButton(text);

        // Force basic Java button interface
        button.setUI(new javax.swing.plaf.basic.BasicButtonUI());

        button.setFont(new Font("Arial", Font.BOLD, 15));

        button.setBackground(color);

        // Make all button text readable
        if (color.equals(GOLD)) {
            button.setForeground(NAVY);
        } else {
            button.setForeground(WHITE);
        }

        // Force button background visibility
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setFocusable(false);

        // Visible button border
        button.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    color.darker(), 2
                ),
                BorderFactory.createEmptyBorder(
                    10, 20, 10, 20
                )
            )
        );

        // Button size
        button.setPreferredSize(
            new Dimension(230, 48)
        );

        button.setMinimumSize(
            new Dimension(200, 45)
        );

        button.setMaximumSize(
            new Dimension(260, 50)
        );

        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setCursor(
            new Cursor(Cursor.HAND_CURSOR)
        );

        // Hover effect
        button.addMouseListener(
            new java.awt.event.MouseAdapter() {

                @Override
                public void mouseEntered(
                    java.awt.event.MouseEvent e
                ) {
                    button.setBackground(color.darker());
                }

                @Override
                public void mouseExited(
                    java.awt.event.MouseEvent e
                ) {
                    button.setBackground(color);
                }
            }
        );

        return button;
    }

    // =====================================
    // 5. PANEL DESIGN
    // =====================================

    JPanel createPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        panel.setBackground(LIGHT);

        return panel;
    }

    // =====================================
    // 6. TITLE DESIGN
    // =====================================

    JLabel createTitle(String text) {

        JLabel title = new JLabel(text);

        title.setFont(
            new Font("Arial", Font.BOLD, 26)
        );

        title.setForeground(NAVY);

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        return title;
    }

    // =====================================
    // 7. TABLE DESIGN
    // =====================================

    void styleTable(JTable table) {
    table.setFont(new Font("Arial", Font.PLAIN, 14));
    table.setRowHeight(38);
    table.setForeground(DARK);
    table.setBackground(WHITE);

    table.setSelectionBackground(BLUE);
    table.setSelectionForeground(WHITE);

    table.setGridColor(new Color(220, 226, 235));
    table.setShowGrid(true);
    table.setIntercellSpacing(new Dimension(10, 5));

    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    JTableHeader header = table.getTableHeader();
    header.setFont(new Font("Arial", Font.BOLD, 14));
    header.setBackground(NAVY);
    header.setForeground(WHITE);
    header.setPreferredSize(new Dimension(header.getWidth(), 42));
    header.setReorderingAllowed(false);

    DefaultTableCellRenderer centerRenderer =
        new DefaultTableCellRenderer();

    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel()
             .getColumn(i)
             .setCellRenderer(centerRenderer);
    }
}


    // =====================================
    // 8. REFRESH SCREEN
    // =====================================

    void refreshScreen() {

        revalidate();
        repaint();
    }

    // =====================================
    // 9. SAMPLE SCHEDULES
    // =====================================

    static void addSampleSchedules() {

    if (!schedules.isEmpty()) {
        return;
    }

    schedules.add(new Schedule(
        "Database Management",
        "Mr. Santos",
        "BSIT 2A",
        "8:00 AM",
        "Room 304"
    ));

    schedules.add(new Schedule(
        "Programming",
        "Ms. Cruz",
        "BSIT 2A",
        "10:00 AM",
        "Room 205"
    ));

    schedules.add(new Schedule(
        "Networking",
        "Mr. Reyes",
        "BSIT 2A",
        "1:00 PM",
        "Room 102"
    ));

    schedules.add(new Schedule(
        "Web Development",
        "Ms. Garcia",
        "BSIT 2B",
        "9:00 AM",
        "Room 201"
    ));
}

    // =====================================
    // 10. WELCOME SCREEN
    // =====================================

    void welcomeScreen() {

        getContentPane().removeAll();

        JPanel panel = createPanel();

        panel.setLayout(
            new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        // School header
        JPanel banner = new JPanel(new GridBagLayout());

        banner.setBackground(NAVY);

        banner.setPreferredSize(
            new Dimension(750, 120)
        );

        banner.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 120)
        );

        JLabel schoolTitle = new JLabel(
            "FIND MY CLASSROOM SYSTEM"
        );

        schoolTitle.setFont(
            new Font("Arial", Font.BOLD, 28)
        );

        schoolTitle.setForeground(WHITE);

        banner.add(schoolTitle);

        JLabel welcome = createTitle("WELCOME!");

        JButton nextButton =
            createButton("GET STARTED", BLUE);

        nextButton.addActionListener(
            e -> mainMenu()
        );

        panel.add(Box.createVerticalGlue());

        panel.add(banner);

        panel.add(Box.createVerticalStrut(45));

        panel.add(welcome);

        panel.add(Box.createVerticalStrut(35));

        panel.add(nextButton);

        panel.add(Box.createVerticalGlue());

        add(panel);

        refreshScreen();
    }

    // =====================================
    // 11. MAIN MENU
    // =====================================

    void mainMenu() {

        getContentPane().removeAll();

        JPanel panel = createPanel();

        panel.setLayout(
            new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        JLabel title = createTitle("MAIN MENU");

        JLabel subtitle = new JLabel(
            "Select your account type"
        );

        subtitle.setFont(
            new Font("Arial", Font.PLAIN, 16)
        );

        subtitle.setForeground(DARK);

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton studentButton =
            createButton("STUDENT", BLUE);

        JButton adminButton =
            createButton("ADMIN", NAVY);

        JButton facultyButton =
            createButton("FACULTY", GOLD);

        JButton exitButton =
            createButton("EXIT", RED);

        studentButton.addActionListener(
            e -> studentScreen()
        );

        adminButton.addActionListener(
            e -> adminLogin()
        );

        facultyButton.addActionListener(
            e -> facultyLogin()
        );

        exitButton.addActionListener(e -> {

            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "EXIT SYSTEM",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        panel.add(Box.createVerticalGlue());

        panel.add(title);

        panel.add(Box.createVerticalStrut(10));

        panel.add(subtitle);

        panel.add(Box.createVerticalStrut(35));

        panel.add(studentButton);

        panel.add(Box.createVerticalStrut(15));

        panel.add(adminButton);

        panel.add(Box.createVerticalStrut(15));

        panel.add(facultyButton);

        panel.add(Box.createVerticalStrut(15));

        panel.add(exitButton);

        panel.add(Box.createVerticalGlue());

        add(panel);

        refreshScreen();
    }

    // =====================================
    // 12. STUDENT SCREEN
    // =====================================

    void studentScreen() {

        getContentPane().removeAll();

        JPanel panel = createPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = createTitle("STUDENT INFORMATION");

        JLabel nameLabel = new JLabel("Enter Name:");

        JTextField nameField = new JTextField(20);

        JLabel sectionLabel = new JLabel("Enter Section:");

        JTextField sectionField = new JTextField(20);

        JButton searchButton =
            createButton("SEARCH", BLUE);

        JButton backButton =
            createButton("BACK", NAVY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        panel.add(title, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(nameLabel, gbc);

        gbc.gridx = 1;

        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        panel.add(sectionLabel, gbc);

        gbc.gridx = 1;

        panel.add(sectionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;

        panel.add(searchButton, gbc);

        gbc.gridx = 1;

        panel.add(backButton, gbc);

        searchButton.addActionListener(e -> {

            String name = nameField.getText().trim();

            String section = sectionField.getText().trim();

            if (name.isEmpty() || section.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter your name and section."
                );

                return;
            }

            showStudentSchedule(name, section);
        });

        backButton.addActionListener(
            e -> mainMenu()
        );

        add(panel);

        refreshScreen();
    }

    // =====================================
    // 13. STUDENT SCHEDULE
    // =====================================

    void showStudentSchedule(String name, String section) {

    getContentPane().removeAll();

    JPanel panel = createPanel();

    panel.setLayout(new BorderLayout(10, 10));

    JLabel title = new JLabel(
        "STUDENT SCHEDULE",
        SwingConstants.CENTER
    );

    title.setFont(new Font("Arial", Font.BOLD, 22));
    title.setForeground(NAVY);

    String[] columns = {
        "Subject", "Teacher", "Section", "Time", "Room"
    };

    DefaultTableModel model =
        new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

    boolean found = false;

    for (Schedule s : schedules) {

        if (s.section.equalsIgnoreCase(section)) {

            model.addRow(new Object[] {
                s.subject,
                s.teacher,
                s.section,
                s.time,
                s.room
            });

            found = true;
        }
    }

    if (!found) {

        JOptionPane.showMessageDialog(
            this,
            "No schedules found for section: " + section,
            "No Results",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    JTable table = new JTable(model);

    styleTable(table);
    table.setCellSelectionEnabled(false);
    table.setRowSelectionAllowed(true);

    JButton backButton =
        createButton("BACK", NAVY);

    backButton.addActionListener(
        e -> studentScreen()
    );

    JPanel bottom = new JPanel();
    bottom.setBackground(LIGHT);
    bottom.add(backButton);

    panel.setBorder(
        BorderFactory.createEmptyBorder(15, 15, 15, 15)
    );

    panel.add(title, BorderLayout.NORTH);
    panel.add(new JScrollPane(table), BorderLayout.CENTER);
    panel.add(bottom, BorderLayout.SOUTH);

    add(panel);

    refreshScreen();
}

    // =====================================
    // 14. FACULTY LOGIN
    // =====================================

    void facultyLogin() {

        JTextField nameField = new JTextField(20);

        Object[] fields = {
            "Enter Faculty Name:",
            nameField
        };

        int result = JOptionPane.showConfirmDialog(
            this,
            fields,
            "FACULTY LOGIN",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {

            String facultyName =
                nameField.getText().trim();

            if (facultyName.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter your faculty name."
                );

                return;
            }

            showFacultySchedule(facultyName);
        }
    }

    // =====================================
    // 15. FACULTY SCHEDULE
    // =====================================

    void showFacultySchedule(String facultyName) {

        getContentPane().removeAll();

        JPanel panel = createPanel();

        panel.setLayout(
            new BorderLayout(10, 10)
        );

        JLabel title = new JLabel(
            "FACULTY SCHEDULE - " + facultyName,
            SwingConstants.CENTER
        );

        title.setFont(
            new Font("Arial", Font.BOLD, 22)
        );

        title.setForeground(NAVY);

        String[] columns = {
            "Subject", "Section", "Time", "Room"
        };

        DefaultTableModel model =
            new DefaultTableModel(columns, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

        for (Schedule s : schedules) {

            if (s.teacher.equalsIgnoreCase(facultyName)) {

                model.addRow(new Object[] {
                    s.subject,
                    s.section,
                    s.time,
                    s.room
                });
            }
        }

        JTable table = new JTable(model);

        styleTable(table);
        table.setCellSelectionEnabled(false);
        table.setRowSelectionAllowed(true);

        JScrollPane scrollPane =
            new JScrollPane(table);

        JButton backButton =
            createButton("BACK TO MENU", NAVY);

        backButton.addActionListener(
            e -> mainMenu()
        );

        JPanel bottom = new JPanel();

        bottom.setBackground(LIGHT);

        bottom.add(backButton);

        panel.setBorder(
            BorderFactory.createEmptyBorder(
                15, 15, 15, 15
            )
        );

        panel.add(title, BorderLayout.NORTH);

        panel.add(scrollPane, BorderLayout.CENTER);

        panel.add(bottom, BorderLayout.SOUTH);

        add(panel);

        refreshScreen();

        if (model.getRowCount() == 0) {

            JOptionPane.showMessageDialog(
                this,
                "No schedule found for faculty: " + facultyName
            );
        }
    }

    // =====================================
    // 16. ADMIN LOGIN
    // =====================================

    void adminLogin() {

        JTextField usernameField = new JTextField(15);

        JPasswordField passwordField =
            new JPasswordField(15);

        Object[] fields = {
            "Username:",
            usernameField,
            "Password:",
            passwordField
        };

        int result = JOptionPane.showConfirmDialog(
            this,
            fields,
            "ADMIN LOGIN",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {

            String username =
                usernameField.getText();

            String password =
                new String(passwordField.getPassword());

            if (username.equals(ADMIN_USERNAME)
                    && password.equals(ADMIN_PASSWORD)) {

                adminMenu();

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Incorrect username or password.",
                    "LOGIN FAILED",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // =====================================
    // 17. ADMIN MENU
    // =====================================

    void adminMenu() {

        getContentPane().removeAll();

        JPanel panel = createPanel();
        

        panel.setLayout(
            new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        JLabel title = createTitle("ADMIN MENU");

        JLabel subtitle = new JLabel(
            "Manage classroom schedules"
        );

        subtitle.setFont(
            new Font("Arial", Font.PLAIN, 16)
        );

        subtitle.setForeground(DARK);

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton viewButton =
            createButton("VIEW SCHEDULES", NAVY);

        JButton editButton =
            createButton("EDIT SCHEDULES", GOLD);

       JButton exportButton =
            createButton("EXPORT SCHEDULES", NAVY);

            exportButton.addActionListener(
            e -> exportSchedules()
);

        JButton backButton =
            createButton("BACK TO MAIN MENU", RED);

        viewButton.addActionListener(
            e -> viewSchedules()
        );

        editButton.addActionListener(
            e -> editSchedules()
        );

        backButton.addActionListener(
            e -> mainMenu()
        );

        panel.add(Box.createVerticalGlue());

        panel.add(title);

        panel.add(Box.createVerticalStrut(10));

        panel.add(subtitle);

        panel.add(Box.createVerticalStrut(35));

        panel.add(viewButton);

        panel.add(Box.createVerticalStrut(15));

        panel.add(editButton);

        panel.add(Box.createVerticalStrut(15));

        panel.add(exportButton);

        panel.add(Box.createVerticalStrut(15));

        panel.add(backButton);

        panel.add(Box.createVerticalGlue());

        add(panel);

        refreshScreen();
    }
    //=====================================
    // 18. EXPORTS SCHEDULES
    // =====================================

    static void exportSchedules() {
        if (schedules.isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "There are no schedules to export.",
                "NO SCHEDULES",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        try (FileWriter writer = new FileWriter("Schedules.txt")) {
            for (Schedule s : schedules) {
                writer.write("Subject: " + s.subject + "\n");
                writer.write("Teacher: " + s.teacher + "\n");
                writer.write("Section: " + s.section + "\n");
                writer.write("Time: " + s.time + "\n");
                writer.write("Room: " + s.room + "\n");
                writer.write("-------------------------\n");
            }

            JOptionPane.showMessageDialog(
                null,
                "Schedules exported successfully to Schedules.txt",
                "EXPORT SUCCESSFUL",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                null,
                "Error exporting schedules: " + e.getMessage(),
                "EXPORT FAILED",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================
    // 19. VIEW ALL SCHEDULES
    // =====================================

    void viewSchedules() {

        getContentPane().removeAll();

        JPanel panel = createPanel();

        panel.setLayout(
            new BorderLayout(10, 10)
        );

        JLabel title = new JLabel(
            "ALL CLASS SCHEDULES",
            SwingConstants.CENTER
        );

        title.setFont(
            new Font("Arial", Font.BOLD, 22)
        );

        title.setForeground(NAVY);

        String[] columns = {
            "Subject", "Teacher", "Section", "Time", "Room"
        };

        DefaultTableModel model =
            new DefaultTableModel(columns, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

        sortSchedulesBySubject();    

        for (Schedule s : schedules) {

            model.addRow(new Object[] {
                s.subject,
                s.teacher,
                s.section,
                s.time,
                s.room
            });
        }

        JTable table = new JTable(model);

        styleTable(table);
        table.setCellSelectionEnabled(false);
        table.setRowSelectionAllowed(true);

        JButton backButton =
            createButton("BACK", NAVY);

        backButton.addActionListener(
            e -> adminMenu()
        );

        JPanel bottom = new JPanel();

        bottom.setBackground(LIGHT);

        bottom.add(backButton);

        panel.setBorder(
            BorderFactory.createEmptyBorder(
                15, 15, 15, 15
            )
        );

        panel.add(title, BorderLayout.NORTH);

        panel.add(
            new JScrollPane(table),
            BorderLayout.CENTER
        );

        panel.add(bottom, BorderLayout.SOUTH);

        add(panel);

        refreshScreen();
    }

    // =====================================
    // 19. EDIT SCHEDULES
    // =====================================

    void editSchedules() {

        String[] options = {
            "ADD SCHEDULE",
            "UPDATE SCHEDULE",
            "DELETE SCHEDULE",
            "BACK"
        };

        int choice = JOptionPane.showOptionDialog(
            this,
            "Choose an action:",
            "EDIT SCHEDULES",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );

        if (choice == 0) {

            addSchedule();

        } else if (choice == 1) {

            updateSchedule();

        } else if (choice == 2) {

            deleteSchedule();

        } else if (choice == 3) {

            adminMenu();
        }
    }

    // =====================================
    // 20. ADD SCHEDULE
    // =====================================

    void addSchedule() {
        JTextField subjectField = new JTextField();
        JTextField teacherField = new JTextField();
        JTextField sectionField = new JTextField();
        JTextField timeField = new JTextField();
        JTextField roomField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Subject:"));
        panel.add(subjectField);
        panel.add(new JLabel("Teacher:"));
        panel.add(teacherField);
        panel.add(new JLabel("Section:"));
        panel.add(sectionField);
        panel.add(new JLabel("Time:"));
        panel.add(timeField);
        panel.add(new JLabel("Room:"));
        panel.add(roomField);

        int result = JOptionPane.showConfirmDialog(
            this, panel, "ADD SCHEDULE",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        String subject = subjectField.getText().trim();
        String teacher = teacherField.getText().trim();
        String section = sectionField.getText().trim();
        String time = timeField.getText().trim();
        String room = roomField.getText().trim();

        if (subject.isEmpty() || teacher.isEmpty()
                || section.isEmpty() || time.isEmpty()
                || room.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Unable to add schedule.\n\n"
                + "Please complete all required fields:\n"
                + "- Subject\n- Teacher\n- Section\n- Time\n- Room",
                "INPUT ERROR",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        for (Schedule s : schedules) {
            if (s.subject.equalsIgnoreCase(subject)
                    && s.teacher.equalsIgnoreCase(teacher)
                    && s.section.equalsIgnoreCase(section)
                    && s.time.equalsIgnoreCase(time)
                    && s.room.equalsIgnoreCase(room)) {

                JOptionPane.showMessageDialog(
                    this,
                    "This schedule already exists.\n"
                    + "Please check the schedule details.",
                    "DUPLICATE SCHEDULE",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        schedules.add(new Schedule(subject, teacher, section, time, room));

        JOptionPane.showMessageDialog(
            this,
            "The new schedule has been added successfully!\n\n"
            + "Subject: " + subject + "\n"
            + "Teacher: " + teacher + "\n"
            + "Section: " + section + "\n"
            + "Time: " + time + "\n"
            + "Room: " + room,
            "SCHEDULE ADDED",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =====================================
    // 21. UPDATE SCHEDULE
    // =====================================

    void updateSchedule() {

        if (schedules.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "There are no schedules available to update.",
                "NO SCHEDULES",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        String[] scheduleOptions = new String[schedules.size()];

        for (int i = 0; i < schedules.size(); i++) {
            Schedule s = schedules.get(i);

            scheduleOptions[i] = s.subject + " - "
                    + s.section + " - "
                    + s.teacher;
        }

        JComboBox<String> scheduleBox =
                new JComboBox<>(scheduleOptions);

        JLabel scheduleLabel = new JLabel("Select Schedule:");
        scheduleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        scheduleLabel.setForeground(DARK);

        JLabel subjectLabel = new JLabel("Subject:");
        JLabel teacherLabel = new JLabel("Teacher:");
        JLabel sectionLabel = new JLabel("Section:");
        JLabel timeLabel = new JLabel("Time:");
        JLabel roomLabel = new JLabel("Room:");

        JTextField subjectField = new JTextField(18);
        JTextField teacherField = new JTextField(18);
        JTextField sectionField = new JTextField(18);
        JTextField timeField = new JTextField(18);
        JTextField roomField = new JTextField(18);

        JLabel[] labels = {
            subjectLabel, teacherLabel, sectionLabel,
            timeLabel, roomLabel
        };

        JTextField[] fields = {
            subjectField, teacherField, sectionField,
            timeField, roomField
        };

        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setForeground(DARK);
        }

        for (JTextField field : fields) {
            field.setFont(new Font("Arial", Font.PLAIN, 14));
        }

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBackground(LIGHT);
        panel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        panel.add(scheduleLabel);
        panel.add(scheduleBox);

        panel.add(subjectLabel);
        panel.add(subjectField);

        panel.add(teacherLabel);
        panel.add(teacherField);

        panel.add(sectionLabel);
        panel.add(sectionField);

        panel.add(timeLabel);
        panel.add(timeField);

        panel.add(roomLabel);
        panel.add(roomField);

        scheduleBox.addActionListener(e -> {
            int index = scheduleBox.getSelectedIndex();

            if (index >= 0) {
                Schedule s = schedules.get(index);

                subjectField.setText(s.subject);
                teacherField.setText(s.teacher);
                sectionField.setText(s.section);
                timeField.setText(s.time);
                roomField.setText(s.room);
            }
        });

        int selectedIndex = scheduleBox.getSelectedIndex();

        if (selectedIndex >= 0) {
            Schedule s = schedules.get(selectedIndex);

            subjectField.setText(s.subject);
            teacherField.setText(s.teacher);
            sectionField.setText(s.section);
            timeField.setText(s.time);
            roomField.setText(s.room);
        }

        int result = JOptionPane.showConfirmDialog(
            this,
            panel,
            "UPDATE SCHEDULE",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {

            String subject = subjectField.getText().trim();
            String teacher = teacherField.getText().trim();
            String section = sectionField.getText().trim();
            String time = timeField.getText().trim();
            String room = roomField.getText().trim();

            if (subject.isEmpty() || teacher.isEmpty()
                    || section.isEmpty() || time.isEmpty()
                    || room.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please complete all schedule information.",
                    "MISSING INFORMATION",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int index = scheduleBox.getSelectedIndex();

            if (index >= 0) {
                Schedule s = schedules.get(index);

                s.subject = subject;
                s.teacher = teacher;
                s.section = section;
                s.time = time;
                s.room = room;

                JOptionPane.showMessageDialog(
                    this,
                    "Schedule updated successfully!",
                    "UPDATE SUCCESSFUL",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }

    // =====================================
    // 22. DELETE SCHEDULE
    // =====================================

    void deleteSchedule() {

        if (schedules.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "There are no schedules available to delete.",
                "NO SCHEDULES",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        String[] scheduleOptions = new String[schedules.size()];

        for (int i = 0; i < schedules.size(); i++) {
            Schedule s = schedules.get(i);

            scheduleOptions[i] = s.subject + " - "
                    + s.section + " - "
                    + s.teacher;
        }

        JComboBox<String> scheduleBox =
                new JComboBox<>(scheduleOptions);

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.setBackground(LIGHT);

        JLabel instruction = new JLabel("Select the schedule to delete:");
        instruction.setFont(new Font("Arial", Font.BOLD, 14));
        instruction.setForeground(NAVY);

        scheduleBox.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(instruction);
        panel.add(scheduleBox);

        int result = JOptionPane.showConfirmDialog(
            this,
            panel,
            "DELETE SCHEDULE",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        int selectedIndex = scheduleBox.getSelectedIndex();

        if (selectedIndex < 0) {
            return;
        }

        Schedule selectedSchedule = schedules.get(selectedIndex);

        int confirmation = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this schedule?\n\n"
                + "Subject: " + selectedSchedule.subject + "\n"
                + "Section: " + selectedSchedule.section + "\n"
                + "Teacher: " + selectedSchedule.teacher,
            "CONFIRM DELETE",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirmation == JOptionPane.YES_OPTION) {

            schedules.remove(selectedIndex);

            JOptionPane.showMessageDialog(
                this,
                "Schedule deleted successfully!",
                "DELETE SUCCESSFUL",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =====================================
    // SORT SCHEDULES BY SUBJECT
    // =====================================

void sortSchedulesBySubject() {
    schedules.sort(
        (s1, s2) -> s1.subject.compareToIgnoreCase(s2.subject)
    );
}

    // =====================================
    // 23. MAIN METHOD
    // =====================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Use consistent cross-platform appearance
            try {

                UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName()
                );

            } catch (Exception ignored) {
            }

            // Dialog styling
            UIManager.put("OptionPane.background", LIGHT);
            UIManager.put("Panel.background", LIGHT);

            UIManager.put(
                "OptionPane.messageForeground", NAVY
            );

            UIManager.put("Button.background", BLUE);
            UIManager.put("Button.foreground", WHITE);

            UIManager.put(
                "Button.font",
                new Font("Arial", Font.BOLD, 13)
            );

            UIManager.put("Button.opaque", Boolean.TRUE);
            UIManager.put("Button.focusPainted", Boolean.FALSE);

            // Load sample schedules
            addSampleSchedules();

            // Start application
            FindMyClassroom system =
                new FindMyClassroom();

            system.setVisible(true);
        });
    }
}
