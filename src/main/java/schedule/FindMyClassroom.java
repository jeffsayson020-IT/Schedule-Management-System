package schedule;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class FindMyClassroom extends JFrame {

    // =====================================
    // SCHOOL COLOR THEME
    // =====================================

   static final Color NAVY = new Color(23, 54, 93);
static final Color BLUE = new Color(40, 120, 200);
static final Color GOLD = new Color(242, 193, 78);
static final Color LIGHT = new Color(244, 247, 251);
static final Color WHITE = Color.WHITE;
static final Color DARK = new Color(40, 50, 65);
static final Color GREEN = new Color(46, 139, 87);
static final Color RED = new Color(190, 65, 65);
static final Color BORDER = new Color(220, 226, 235);

    // =====================================
    // SCHEDULE DATA
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
    // CONSTRUCTOR
    // =====================================

    public FindMyClassroom() {

        setTitle("Find My Classroom System");
        setSize(750, 550);
        setMinimumSize(new Dimension(650, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(LIGHT);

        welcomeScreen();
    }

    // =====================================
    // BUTTON DESIGN - FIXED VISIBILITY
    // =====================================


  JButton createButton(String text, Color color) {

    JButton button = new JButton(text);

    button.setUI(new javax.swing.plaf.basic.BasicButtonUI());

    button.setFont(new Font("Arial", Font.BOLD, 16));
    button.setForeground(WHITE);
    button.setBackground(color);

    button.setFocusPainted(false);
    button.setBorder(
        BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color.darker(), 1),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        )
    );

    button.setPreferredSize(new Dimension(230, 48));
    button.setMinimumSize(new Dimension(200, 45));
    button.setMaximumSize(new Dimension(260, 50));

    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));

    button.addMouseListener(new java.awt.event.MouseAdapter() {

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            button.setBackground(color.brighter());
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            button.setBackground(color);
        }
    });

    return button;
}

    // =====================================
    // PANEL DESIGN
    // =====================================

    JPanel createPanel() {

        JPanel panel = new JPanel();

        panel.setBackground(LIGHT);

        return panel;
    }

    // =====================================
    // TITLE DESIGN
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
    // TABLE DESIGN
    // =====================================

    void styleTable(JTable table) {

        table.setFont(
            new Font("Arial", Font.PLAIN, 14)
        );

        table.setRowHeight(34);

        table.setBackground(WHITE);
        table.setForeground(DARK);

        table.setSelectionBackground(BLUE);
        table.setSelectionForeground(WHITE);

        table.setGridColor(
            new Color(220, 226, 235)
        );

        table.setShowGrid(true);
        table.setFillsViewportHeight(true);

        JTableHeader header = table.getTableHeader();

        header.setBackground(NAVY);
        header.setForeground(WHITE);

        header.setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        header.setPreferredSize(
            new Dimension(0, 38)
        );
    }

    // =====================================
    // REFRESH SCREEN
    // =====================================

      void refreshScreen() {

        revalidate();
        repaint();
    }

    // =====================================
// SCREEN NAVIGATION
// =====================================

void changeScreen(JPanel panel) {

    getContentPane().removeAll();

    add(panel);

    refreshScreen();
}

    // =====================================
    // SAMPLE SCHEDULES
    // =====================================

    static void addSampleSchedules() {

        schedules.add(new Schedule(
            "Database Management",
            "Mr. Perez",
            "BSIT 2A",
            "8:00 AM",
            "Room 304"
        ));

        schedules.add(new Schedule(
            "Programming",
            "Ms. Mendoza",
            "BSIT 2A",
            "10:00 AM",
            "Room 205"
        ));

        schedules.add(new Schedule(
            "Networking",
            "Mr. Reyes",
            "BSIT 05",
            "1:00 PM",
            "Room 102"
        ));

        schedules.add(new Schedule(
            "Web Development",
            "Mr. Garcia",
            "BSIT 2B",
            "9:00 AM",
            "Room 201"
        ));
    }

    // =====================================
    // WELCOME SCREEN
    // =====================================

   void welcomeScreen() {
    getContentPane().removeAll();

    // Main background panel
    JPanel root = createPanel();
    root.setLayout(new BorderLayout());
    root.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

    // Center card
    JPanel card = new JPanel();
    card.setBackground(WHITE);
    card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
    card.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(220, 226, 235), 1),
        BorderFactory.createEmptyBorder(30, 35, 30, 35)
    ));

    // Navy banner
    JPanel banner = new JPanel();
    banner.setBackground(NAVY);
    banner.setLayout(new BoxLayout(banner, BoxLayout.Y_AXIS));
    banner.setBorder(BorderFactory.createEmptyBorder(25, 15, 25, 15));

    JLabel emblem = new JLabel();
    emblem.setFont(new Font("Arial", Font.BOLD, 30));
    emblem.setForeground(GOLD);
    emblem.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel systemTitle = new JLabel("FIND MY CLASSROOM SYSTEM");
    systemTitle.setFont(new Font("Arial", Font.BOLD, 20));
    systemTitle.setForeground(WHITE);
    systemTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

    banner.add(emblem);
    banner.add(Box.createVerticalStrut(10));
    banner.add(systemTitle);

    // Welcome message
    JLabel welcome = new JLabel("WELCOME!");
    welcome.setFont(new Font("Arial", Font.BOLD, 32));
    welcome.setForeground(NAVY);
    welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel description = new JLabel(
        "<html><div style='text-align:center;'>"
        + "Find your class schedule quickly and easily. Stay<br>"
        + "Organized and never miss your class!"
        + "</div></html>"
    );
    description.setFont(new Font("Arial", Font.PLAIN, 15));
    description.setForeground(DARK);
    description.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Get started button
    JButton startButton = createButton("GET STARTED", BLUE);
    startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    startButton.addActionListener(e -> mainMenu());

    // Add everything to the card
    card.add(banner);
    card.add(Box.createVerticalStrut(35));
    card.add(welcome);
    card.add(Box.createVerticalStrut(15));
    card.add(description);
    card.add(Box.createVerticalStrut(35));
    card.add(startButton);

    // Center the card
    JPanel centerPanel = new JPanel(new GridBagLayout());
    centerPanel.setBackground(root.getBackground());
    centerPanel.add(card);

    root.add(centerPanel, BorderLayout.CENTER);

    add(root);
    refreshScreen();
}

    // =====================================
    // MAIN MENU
    // =====================================

    void mainMenu() {

        getContentPane().removeAll();

        JPanel panel = createPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(
            BorderFactory.createEmptyBorder(25, 30, 25, 30)
        );

        JLabel title = createTitle("MAIN MENU");

        JLabel subtitle = new JLabel(
            "Select your account type"
        );
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitle.setForeground(DARK);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton studentButton = createButton("STUDENT", BLUE);
        JButton adminButton = createButton("ADMIN", NAVY);
        JButton facultyButton = createButton("FACULTY", GOLD);
        JButton exitButton = createButton("EXIT", RED);

        studentButton.addActionListener(e -> studentScreen());
        adminButton.addActionListener(e -> adminLogin());
        facultyButton.addActionListener(e -> facultyLogin());

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
        panel.add(Box.createVerticalStrut(12));

        panel.add(subtitle);
        panel.add(Box.createVerticalStrut(40));

        panel.add(studentButton);
        panel.add(Box.createVerticalStrut(18));

        panel.add(adminButton);
        panel.add(Box.createVerticalStrut(18));

        panel.add(facultyButton);
        panel.add(Box.createVerticalStrut(18));

        panel.add(exitButton);

        panel.add(Box.createVerticalGlue());

        add(panel);

        refreshScreen();
    }

    // =====================================
    // STUDENT SCREEN
    // =====================================

    
    // =====================================
    // STUDENT SCREEN - COMMIT 11
    // =====================================

    void studentScreen() {

        getContentPane().removeAll();

        JPanel panel = createPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = createTitle("STUDENT INFORMATION");

        JLabel subtitle = new JLabel(
            "Enter your information to find your class schedule"
        );
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(DARK);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(DARK);

        JTextField nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel sectionLabel = new JLabel("Section:");
        sectionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        sectionLabel.setForeground(DARK);

        JTextField sectionField = new JTextField(20);
        sectionField.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton searchButton = createButton("SEARCH", BLUE);
        JButton backButton = createButton("BACK", NAVY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        panel.add(title, gbc);

        gbc.gridy = 1;
        panel.add(subtitle, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(sectionLabel, gbc);

        gbc.gridx = 1;
        panel.add(sectionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(searchButton, gbc);

        gbc.gridx = 1;
        panel.add(backButton, gbc);

        searchButton.addActionListener(e -> {

            String name = nameField.getText().trim();
            String section = sectionField.getText().trim();

            if (name.isEmpty() || section.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter your name and section.",
                    "MISSING INFORMATION",
                    JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            showStudentSchedule(name, section);
        });

        backButton.addActionListener(e -> mainMenu());

        add(panel);

        refreshScreen();
    }

    // =====================================
    // STUDENT SCHEDULE
    // =====================================

    void showStudentSchedule(String name, String section) {

        getContentPane().removeAll();

        JPanel panel = createPanel();

        panel.setLayout(
            new BorderLayout(10, 10)
        );

        JLabel title = new JLabel(
            "CLASS SCHEDULE - " + section,
            SwingConstants.CENTER
        );

        title.setFont(
            new Font("Arial", Font.BOLD, 22)
        );

        title.setForeground(NAVY);

        JLabel studentName = new JLabel(
            "Student: " + name,
            SwingConstants.CENTER
        );

        studentName.setFont(
            new Font("Arial", Font.PLAIN, 15)
        );

        studentName.setForeground(DARK);

        JPanel heading = new JPanel(
            new GridLayout(2, 1, 5, 5)
        );

        heading.setBackground(LIGHT);
        heading.add(title);
        heading.add(studentName);

        String[] columns = {
            "Subject", "Teacher", "Time", "Room"
        };

        DefaultTableModel model =
            new DefaultTableModel(columns, 0);

        for (Schedule s : schedules) {

            if (s.section.trim().equalsIgnoreCase(section.trim())) {

                model.addRow(new Object[] {
                    s.subject,
                    s.teacher,
                    s.time,
                    s.room
                });
            }
        }

        JTable table = new JTable(model);

        styleTable(table);

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

        panel.add(heading, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);

        add(panel);

        refreshScreen();

        if (model.getRowCount() == 0) {

            JOptionPane.showMessageDialog(
                this,
                "No schedule found for section: " + section,
                "NO SCHEDULE FOUND",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }


    // =====================================
    // FACULTY LOGIN
    // =====================================

   
void facultyLogin() {

    JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
    panel.setBackground(LIGHT);
    panel.setBorder(
        BorderFactory.createEmptyBorder(15, 20, 15, 20)
    );

    JLabel title = new JLabel(
        "FACULTY LOGIN",
        SwingConstants.CENTER
    );
    title.setFont(new Font("Arial", Font.BOLD, 20));
    title.setForeground(NAVY);

    JLabel instruction = new JLabel(
        "Enter your faculty name to view your schedule.",
        SwingConstants.CENTER
    );
    instruction.setFont(new Font("Arial", Font.PLAIN, 13));
    instruction.setForeground(DARK);

    JTextField facultyField = new JTextField();
    facultyField.setFont(new Font("Arial", Font.PLAIN, 15));

    panel.add(title);
    panel.add(instruction);
    panel.add(facultyField);

    int result = JOptionPane.showConfirmDialog(
        this,
        panel,
        "FACULTY LOGIN",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {

        String facultyName = facultyField.getText().trim();

        if (facultyName.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter your faculty name.",
                "MISSING INFORMATION",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        showFacultySchedule(facultyName);
    }
}


    // =====================================
    // FACULTY SCHEDULE
    // =====================================

   void showFacultySchedule(String facultyName) {

    getContentPane().removeAll();

    JPanel panel = createPanel();
    panel.setLayout(new BorderLayout(10, 10));

    JLabel title = new JLabel(
        "FACULTY CLASS SCHEDULE",
        SwingConstants.CENTER
    );
    title.setFont(new Font("Arial", Font.BOLD, 22));
    title.setForeground(NAVY);

    JLabel facultyLabel = new JLabel(
        "Faculty: " + facultyName,
        SwingConstants.CENTER
    );
    facultyLabel.setFont(new Font("Arial", Font.PLAIN, 15));
    facultyLabel.setForeground(DARK);

    JPanel heading = new JPanel(new GridLayout(2, 1, 5, 5));
    heading.setBackground(LIGHT);
    heading.add(title);
    heading.add(facultyLabel);

    String[] columns = {
        "Subject", "Section", "Time", "Room"
    };

    DefaultTableModel model = new DefaultTableModel(columns, 0);

    for (Schedule s : schedules) {
        if (s.teacher.trim().equalsIgnoreCase(facultyName.trim())) {
            model.addRow(new Object[] {
                s.subject, s.section, s.time, s.room
            });
        }
    }

    JTable table = new JTable(model);
    styleTable(table);

    JScrollPane scrollPane = new JScrollPane(table);

    JLabel resultLabel;

    if (model.getRowCount() > 0) {
        resultLabel = new JLabel(
            "Total schedules found: " + model.getRowCount(),
            SwingConstants.CENTER
        );
    } else {
        resultLabel = new JLabel(
            "No schedules found for this faculty member.",
            SwingConstants.CENTER
        );
    }

    resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
    resultLabel.setForeground(DARK);

    JButton backButton = createButton("BACK TO MENU", NAVY);
    backButton.addActionListener(e -> mainMenu());

    JPanel bottom = new JPanel(new GridLayout(2, 1, 5, 5));
    bottom.setBackground(LIGHT);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(LIGHT);
    buttonPanel.add(backButton);

    bottom.add(resultLabel);
    bottom.add(buttonPanel);

    panel.setBorder(
        BorderFactory.createEmptyBorder(15, 15, 15, 15)
    );

    panel.add(heading, BorderLayout.NORTH);
    panel.add(scrollPane, BorderLayout.CENTER);
    panel.add(bottom, BorderLayout.SOUTH);

    add(panel);
    refreshScreen();
}
    // =====================================
    // ADMIN LOGIN
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
    // ADMIN MENU
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

        panel.add(backButton);

        panel.add(Box.createVerticalGlue());

        add(panel);

        refreshScreen();
    }

    // =====================================
    // VIEW ALL SCHEDULES
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
            new DefaultTableModel(columns, 0);

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
    // EDIT SCHEDULES
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
    // ADD SCHEDULE
    // =====================================

    void addSchedule() {

        JTextField subject = new JTextField(15);
        JTextField teacher = new JTextField(15);
        JTextField section = new JTextField(15);
        JTextField time = new JTextField(15);
        JTextField room = new JTextField(15);

        Object[] fields = {
            "Subject:", subject,
            "Teacher:", teacher,
            "Section:", section,
            "Time:", time,
            "Room:", room
        };

        int result = JOptionPane.showConfirmDialog(
            this,
            fields,
            "ADD SCHEDULE",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {

            if (subject.getText().trim().isEmpty()
                    || teacher.getText().trim().isEmpty()
                    || section.getText().trim().isEmpty()
                    || time.getText().trim().isEmpty()
                    || room.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please complete all fields."
                );

                return;
            }

            schedules.add(new Schedule(
                subject.getText().trim(),
                teacher.getText().trim(),
                section.getText().trim(),
                time.getText().trim(),
                room.getText().trim()
            ));

            JOptionPane.showMessageDialog(
                this,
                "Schedule added successfully!",
                "SUCCESS",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =====================================
    // UPDATE SCHEDULE
    // =====================================

    void updateSchedule() {

        if (schedules.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "No schedules available."
            );

            return;
        }

        String[] scheduleList =
            new String[schedules.size()];

        for (int i = 0; i < schedules.size(); i++) {

            Schedule s = schedules.get(i);

            scheduleList[i] =
                s.subject + " - "
                + s.section + " - "
                + s.room;
        }

        String selected =
            (String) JOptionPane.showInputDialog(
                this,
                "Select schedule:",
                "UPDATE SCHEDULE",
                JOptionPane.QUESTION_MESSAGE,
                null,
                scheduleList,
                scheduleList[0]
            );

        if (selected == null) {
            return;
        }

        int index = -1;

        for (int i = 0; i < scheduleList.length; i++) {

            if (scheduleList[i].equals(selected)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return;
        }

        Schedule s = schedules.get(index);

        JTextField subject =
            new JTextField(s.subject, 15);

        JTextField teacher =
            new JTextField(s.teacher, 15);

        JTextField section =
            new JTextField(s.section, 15);

        JTextField time =
            new JTextField(s.time, 15);

        JTextField room =
            new JTextField(s.room, 15);

        Object[] fields = {
            "Subject:", subject,
            "Teacher:", teacher,
            "Section:", section,
            "Time:", time,
            "Room:", room
        };

        int result = JOptionPane.showConfirmDialog(
            this,
            fields,
            "UPDATE SCHEDULE",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {

            if (subject.getText().trim().isEmpty()
                    || teacher.getText().trim().isEmpty()
                    || section.getText().trim().isEmpty()
                    || time.getText().trim().isEmpty()
                    || room.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please complete all fields."
                );

                return;
            }

            s.subject = subject.getText().trim();
            s.teacher = teacher.getText().trim();
            s.section = section.getText().trim();
            s.time = time.getText().trim();
            s.room = room.getText().trim();

            JOptionPane.showMessageDialog(
                this,
                "Schedule updated successfully!",
                "SUCCESS",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =====================================
    // DELETE SCHEDULE
    // =====================================

    void deleteSchedule() {

        if (schedules.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "No schedules available."
            );

            return;
        }

        String[] scheduleList =
            new String[schedules.size()];

        for (int i = 0; i < schedules.size(); i++) {

            Schedule s = schedules.get(i);

            scheduleList[i] =
                s.subject + " - "
                + s.section + " - "
                + s.room;
        }

        String selected =
            (String) JOptionPane.showInputDialog(
                this,
                "Select schedule to delete:",
                "DELETE SCHEDULE",
                JOptionPane.QUESTION_MESSAGE,
                null,
                scheduleList,
                scheduleList[0]
            );

        if (selected == null) {
            return;
        }

        for (int i = 0; i < scheduleList.length; i++) {

            if (scheduleList[i].equals(selected)) {

                int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete "
                    + selected + "?",
                    "CONFIRM DELETE",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );

                if (confirm == JOptionPane.YES_OPTION) {

                    schedules.remove(i);

                    JOptionPane.showMessageDialog(
                        this,
                        "Schedule deleted successfully!",
                        "SUCCESS",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }

                break;
            }
        }
    }

    // =====================================
    // MAIN METHOD
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