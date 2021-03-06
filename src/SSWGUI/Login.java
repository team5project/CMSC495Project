/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSWGUI;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;

/**
 * @author Alan
 */
public class Login extends javax.swing.JFrame {

    static Login myLogin = new Login();
    AWSConnection conn = new AWSConnection();
    PreparedStatement ps;
    ResultSet rs;
	String sessionUserName;

    public Login() {
        initComponents();
        conn.dbConnection();
        showRankings();
        showScores();
    }

    /**
     * Gets team ranking information from the database.
     * @author Keenan
     * @return rankings
     */
    public ArrayList<TeamRanking> teamRankings(){
        ArrayList<TeamRanking> rankings = new ArrayList<>();
        try{
            ps = conn.dbConnection().prepareStatement("SELECT * FROM team_ranking");
            rs = ps.executeQuery();
            TeamRanking teamRanking;
            while (rs.next()){
                teamRanking = new TeamRanking(rs.getString("team"),rs.getInt("ranking"),
                                              rs.getInt("wins"),rs.getInt("losses"),
                                              rs.getInt("draws"),rs.getInt("goals_for"),
                                              rs.getInt("goals_against"));
                rankings.add(teamRanking);
            }
            ps.close();
            rs.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return rankings;
    }

    /**
     * Gets team scores information from the database.
     * @author Keenan
     * @return scores
     */
    public ArrayList<ScoreResults> scoreResults(){
        ArrayList<ScoreResults> scores = new ArrayList<>();
        try{
           ps = conn.dbConnection().prepareStatement("SELECT * FROM score_result");
           rs = ps.executeQuery();
           ScoreResults scoreResults;
           while (rs.next()){
               scoreResults = new ScoreResults(rs.getString("score_date"),rs.getString("home_team"),
                                               rs.getInt("home_goals"),rs.getString("away_team"),
                                               rs.getInt("away_goals"),rs.getString("venue"));
               scores.add(scoreResults);
           }
           ps.close();
           rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return scores;
    }



    /**
     * Modifies homeStandingsTable to show rankings.
     * @author Keenan
     * @return void
     */
    public void showRankings(){
        ArrayList<TeamRanking> rankingList = teamRankings();
        DefaultTableModel model = (DefaultTableModel) homeStandingsTable.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < rankingList.size(); i++){
            row[0] = rankingList.get(i).getTeam();
            row[1] = rankingList.get(i).getRanking();
            row[2] = rankingList.get(i).getWins();
            row[3] = rankingList.get(i).getLosses();
            row[4] = rankingList.get(i).getDraws();
            row[5] = rankingList.get(i).getGoalsFor();
            row[6] = rankingList.get(i).getGoalsAgainst();
            model.addRow(row);
        }

    }
    /**
     * Modifies resultsScoresTable to show rankings.
     * @author Keenan
     * @return void
     */
    public void showScores(){
            ArrayList<ScoreResults> scoreResults = scoreResults();
            DefaultTableModel model = (DefaultTableModel) resultsScoresTable.getModel();
            Object[] row = new Object[6];
        for (int i = 0; i < scoreResults.size(); i++){
            row[0] = scoreResults.get(i).getDate();
            row[1] = scoreResults.get(i).getHomeTeam();
            row[2] = scoreResults.get(i).getHomeGoals();
            row[3] = scoreResults.get(i).getAwayTeam();
            row[4] = scoreResults.get(i).getAwayGoals();
            row[5] = scoreResults.get(i).getVenue();
            model.addRow(row);
        }
    }

    /**
     * Gets week 35 match information from the database.
     * @author Keenan
     * @return week35
     */
    public ArrayList<UpcomingGames>upcomingGames35(){
        ArrayList<UpcomingGames> week35 = new ArrayList<>();
        try{
            ps = conn.dbConnection().prepareStatement("SELECT * FROM upcoming_week_35");
            rs = ps.executeQuery();
            UpcomingGames upcomingGames;
            while (rs.next()){
                upcomingGames = new UpcomingGames(rs.getString("match_date"),
                        rs.getString("away_team"),
                        rs.getString("home_team"));
                week35.add(upcomingGames);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return week35;
    }
    /**
     * Gets week 36 match information from the database.
     * @author Keenan
     * @return week36
     */
    public ArrayList<UpcomingGames>upcomingGames36(){
        ArrayList<UpcomingGames> week36 = new ArrayList<>();
        try{
            ps = conn.dbConnection().prepareStatement("SELECT * FROM upcoming_week_36");
            rs = ps.executeQuery();
            UpcomingGames upcomingGames;
            while (rs.next()){
                upcomingGames = new UpcomingGames(rs.getString("match_date"),
                        rs.getString("away_team"),
                        rs.getString("home_team"));
                week36.add(upcomingGames);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return week36;
    }

    /**
     * Gets week 37 match information from the database.
     * @author Keenan
     * @return week37
     */
    public ArrayList<UpcomingGames>upcomingGames37(){
        ArrayList<UpcomingGames> week37 = new ArrayList<>();
        try{
            ps = conn.dbConnection().prepareStatement("SELECT * FROM upcoming_week_37");
            rs = ps.executeQuery();
            UpcomingGames upcomingGames;
            while (rs.next()){
                upcomingGames = new UpcomingGames(rs.getString("match_date"),
                        rs.getString("away_team"),
                        rs.getString("home_team"));
                week37.add(upcomingGames);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return week37;
    }

    /**
     * Gets week 38 match information from the database.
     * @author Keenan
     * @return week38
     */
    public ArrayList<UpcomingGames>upcomingGames38(){
        ArrayList<UpcomingGames> week38 = new ArrayList<>();
        try{
            ps = conn.dbConnection().prepareStatement("SELECT * FROM upcoming_week_38");
            rs = ps.executeQuery();
            UpcomingGames upcomingGames;
            while (rs.next()){
                upcomingGames = new UpcomingGames(rs.getString("match_date"),
                                                  rs.getString("away_team"),
                                                  rs.getString("home_team"));
                week38.add(upcomingGames);

            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return week38;
    }



    /**
     * Modifies upcomingScheduleTable to show match data for that week.
     * Data includes Match Date, Home Team, and Away Team
     * @author Keenan
     * @return void
     */
    public void showUpcomingWeek35(){
        ArrayList<UpcomingGames> week35 = upcomingGames35();
        DefaultTableModel matchModel = (DefaultTableModel) upcomingScheduleTable.getModel();
        Object[] row = new Object[3];
        matchModel.setRowCount(0);
        for (int i = 0; i < week35.size(); i++){
            row[0] = week35.get(i).getDate();
            row[1] = week35.get(i).getAwayTeam();
            row[2] = week35.get(i).getHomeTeam();
            matchModel.addRow(row);
        }
    }
    public void showUpcomingWeek36(){
        ArrayList<UpcomingGames> week36 = upcomingGames36();
        DefaultTableModel matchModel = (DefaultTableModel) upcomingScheduleTable.getModel();
        Object[] row = new Object[3];
        matchModel.setRowCount(0);
        for (int i = 0; i < week36.size(); i++){
            row[0] = week36.get(i).getDate();
            row[1] = week36.get(i).getAwayTeam();
            row[2] = week36.get(i).getHomeTeam();
            matchModel.addRow(row);
        }
    }

    public void showUpcomingWeek37(){
        ArrayList<UpcomingGames> week37 = upcomingGames37();
        DefaultTableModel matchModel = (DefaultTableModel) upcomingScheduleTable.getModel();
        Object[] row = new Object[3];
        matchModel.setRowCount(0);
        for (int i = 0; i < week37.size(); i++){
            row[0] = week37.get(i).getDate();
            row[1] = week37.get(i).getAwayTeam();
            row[2] = week37.get(i).getHomeTeam();
            matchModel.addRow(row);
        }
    }
    public void showUpcomingWeek38() {
        ArrayList<UpcomingGames> week38 = upcomingGames38();
        DefaultTableModel matchModel = (DefaultTableModel) upcomingScheduleTable.getModel();
        Object[] row = new Object[3];
        matchModel.setRowCount(0);
        for (int i = 0; i < week38.size(); i++) {
            row[0] = week38.get(i).getDate();
            row[1] = week38.get(i).getAwayTeam();
            row[2] = week38.get(i).getHomeTeam();
            matchModel.addRow(row);
        }
    }


    /*********************************************************/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wagersButtonGroup = new javax.swing.ButtonGroup();
        loginPanel = new javax.swing.JPanel();
        loginRegisterButton = new javax.swing.JButton();
        loginLoginButton = new javax.swing.JButton();
        loginPasswordLabel = new javax.swing.JLabel();
        loginUsernameLabel = new javax.swing.JLabel();
        loginUsernameTextField = new javax.swing.JTextField();
        loginPasswordField = new javax.swing.JPasswordField();
        loginHeadingLabel = new javax.swing.JLabel();
        registerPanel = new javax.swing.JPanel();
        registerPanel.setVisible(false);
        registerHeadingLabel = new javax.swing.JLabel();
        registerUsernameLabel = new javax.swing.JLabel();
        registerPasswordLabel = new javax.swing.JLabel();
        registerUsernameTextField = new javax.swing.JTextField();
        registerPasswordField = new javax.swing.JPasswordField();
        registerRegisterButton = new javax.swing.JButton();
        registerTermsJSP = new javax.swing.JScrollPane();
        registerTermsTextArea = new javax.swing.JTextArea();
        homePanel = new javax.swing.JPanel();
        homePanel.setVisible(false);
        homeHeadingLabel = new javax.swing.JLabel();
        homeUpcomingGamesButton = new javax.swing.JButton();
        homeScoresButton = new javax.swing.JButton();
        homeTeamsComboBox = new javax.swing.JComboBox<>();
        homeGoButton = new javax.swing.JButton();
        homeJSP = new javax.swing.JScrollPane();
        homeStandingsTable = new javax.swing.JTable();
        resultsPanel = new javax.swing.JPanel();
        resultsPanel.setVisible(false);
        resultsHeadingLabel = new javax.swing.JLabel();
        resultsJSP = new javax.swing.JScrollPane();
        resultsScoresTable = new javax.swing.JTable();
        resultsBackButton = new javax.swing.JButton();
        upcomingGamesPanel = new javax.swing.JPanel();
        upcomingGamesPanel.setVisible(false);
        upcomingHeadingLabel = new javax.swing.JLabel();
        upcomingJCB = new javax.swing.JComboBox<>();
        upcomingGoButton = new javax.swing.JButton();
        upcomingJSP = new javax.swing.JScrollPane();
        upcomingScheduleTable = new javax.swing.JTable();
        upcomingBackButton = new javax.swing.JButton();
        upcomingGame1Button = new javax.swing.JButton();
        upcomingGame2Button = new javax.swing.JButton();
        upcomingGame3Button = new javax.swing.JButton();
        upcomingGame4Button = new javax.swing.JButton();
        upcomingGame5Button = new javax.swing.JButton();
        upcomingGame6Button = new javax.swing.JButton();
        upcomingGame7Button = new javax.swing.JButton();
        upcomingGame8Button = new javax.swing.JButton();
        upcomingGame9Button = new javax.swing.JButton();
        upcomingGame10Button = new javax.swing.JButton();
        wagersPanel = new javax.swing.JPanel();
        wagersPanel.setVisible(false);
        wagersHeadingLabel = new javax.swing.JLabel();
        wagersJSP = new javax.swing.JScrollPane();
        wagersTable = new javax.swing.JTable();
        wagersWagerTextField = new javax.swing.JTextField();
        wagersOverRB = new javax.swing.JRadioButton();
        wagersUnderRB = new javax.swing.JRadioButton();
        wagersBackButton = new javax.swing.JButton();
        wagersSubmitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        thankYouPanel = new javax.swing.JPanel();
        thankYouPanel.setVisible(false);
        jLabel1 = new javax.swing.JLabel();
        thankYouJSP = new javax.swing.JScrollPane();
        thankYouTextArea = new javax.swing.JTextArea();
        thankYouHomeButton = new javax.swing.JButton();
        thankYouExitButton = new javax.swing.JButton();
        arsenalPanel = new javax.swing.JPanel();
        arsenalPanel.setVisible(false);
        arsenalHeadingLabel = new javax.swing.JLabel();
        arsenalTeamLabel = new javax.swing.JLabel();
        arsenalScheduleLabel = new javax.swing.JLabel();
        arsenalJSP = new javax.swing.JScrollPane();
        arsenalTable = new javax.swing.JTable();
        arsenalBackButton = new javax.swing.JButton();
        arsenalLogoLabel = new javax.swing.JLabel();
        astonPanel = new javax.swing.JPanel();
        astonPanel.setVisible(false);
        astonHeadingLabel = new javax.swing.JLabel();
        astonTeamLabel = new javax.swing.JLabel();
        astonScheduleLabel = new javax.swing.JLabel();
        astonJSP = new javax.swing.JScrollPane();
        astonTable = new javax.swing.JTable();
        astonBackButton = new javax.swing.JButton();
        astonLogoLabel = new javax.swing.JLabel();
        bournemouthPanel = new javax.swing.JPanel();
        bournemouthPanel.setVisible(false);
        bournemouthHeadingLabel = new javax.swing.JLabel();
        bournemouthTeamLabel = new javax.swing.JLabel();
        bournemouthScheduleLabel = new javax.swing.JLabel();
        bournemouthJSP = new javax.swing.JScrollPane();
        bournemouthTable = new javax.swing.JTable();
        bournemouthBackButton = new javax.swing.JButton();
        bournemouthLogoLabel = new javax.swing.JLabel();
        brightonPanel = new javax.swing.JPanel();
        brightonPanel.setVisible(false);
        brightonHeadingLabel = new javax.swing.JLabel();
        brightonTeamLabel = new javax.swing.JLabel();
        brightonScheduleLabel = new javax.swing.JLabel();
        brightonJSP = new javax.swing.JScrollPane();
        brightonTable = new javax.swing.JTable();
        brightonBackButton = new javax.swing.JButton();
        brightonLogoLabel = new javax.swing.JLabel();
        burnleyPanel = new javax.swing.JPanel();
        burnleyPanel.setVisible(false);
        burnleyHeadingLabel = new javax.swing.JLabel();
        burnleyTeamLabel = new javax.swing.JLabel();
        burnleyScheduleLabel = new javax.swing.JLabel();
        burnleyJSP = new javax.swing.JScrollPane();
        burnleyTable = new javax.swing.JTable();
        burnleyBackButton = new javax.swing.JButton();
        burnleyLogoLabel = new javax.swing.JLabel();
        chelseaPanel = new javax.swing.JPanel();
        chelseaPanel.setVisible(false);
        chelseaHeadingLabel = new javax.swing.JLabel();
        chelseaTeamLabel = new javax.swing.JLabel();
        chelseaScheduleLabel = new javax.swing.JLabel();
        chelseaJSP = new javax.swing.JScrollPane();
        chelseaTable = new javax.swing.JTable();
        chelseaBackButton = new javax.swing.JButton();
        chelseaLogoLabel = new javax.swing.JLabel();
        cpPanel = new javax.swing.JPanel();
        cpPanel.setVisible(false);
        cpHeadingLabel = new javax.swing.JLabel();
        cpTeamLabel = new javax.swing.JLabel();
        cpScheduleLabel = new javax.swing.JLabel();
        cpJSP = new javax.swing.JScrollPane();
        cpTable = new javax.swing.JTable();
        cpBackButton = new javax.swing.JButton();
        cpLogoLabel = new javax.swing.JLabel();
        evertonPanel = new javax.swing.JPanel();
        evertonPanel.setVisible(false);
        evertonHeadingLabel = new javax.swing.JLabel();
        evertonTeamLabel = new javax.swing.JLabel();
        evertonScheduleLabel = new javax.swing.JLabel();
        evertonJSP = new javax.swing.JScrollPane();
        evertonTable = new javax.swing.JTable();
        evertonBackButton = new javax.swing.JButton();
        evertonLogoLabel = new javax.swing.JLabel();
        lcPanel = new javax.swing.JPanel();
        lcPanel.setVisible(false);
        lcHeadingLabel = new javax.swing.JLabel();
        lcTeamLabel = new javax.swing.JLabel();
        lcScheduleLabel = new javax.swing.JLabel();
        lcJSP = new javax.swing.JScrollPane();
        lcTable = new javax.swing.JTable();
        lcBackButton = new javax.swing.JButton();
        lcLogoLabel = new javax.swing.JLabel();
        liverpoolPanel = new javax.swing.JPanel();
        liverpoolPanel.setVisible(false);
        liverpoolHeadingLabel = new javax.swing.JLabel();
        liverpoolTeamLabel = new javax.swing.JLabel();
        liverpoolScheduleLabel = new javax.swing.JLabel();
        liverpoolJSP = new javax.swing.JScrollPane();
        liverpoolTable = new javax.swing.JTable();
        liverpoolBackButton = new javax.swing.JButton();
        liverpoolLogoLabel = new javax.swing.JLabel();
        manCityPanel = new javax.swing.JPanel();
        manCityPanel.setVisible(false);
        manCityHeadingLabel = new javax.swing.JLabel();
        manCityTeamLabel = new javax.swing.JLabel();
        manCityScheduleLabel = new javax.swing.JLabel();
        manCityJSP = new javax.swing.JScrollPane();
        manCityTable = new javax.swing.JTable();
        manCityBackButton = new javax.swing.JButton();
        manCityLogoLabel = new javax.swing.JLabel();
        manUnitedPanel = new javax.swing.JPanel();
        manUnitedPanel.setVisible(false);
        manUnitedHeadingLabel = new javax.swing.JLabel();
        manUnitedTeamLabel = new javax.swing.JLabel();
        manUnitedScheduleLabel = new javax.swing.JLabel();
        manUnitedJSP = new javax.swing.JScrollPane();
        manUnitedTable = new javax.swing.JTable();
        manUnitedBackButton = new javax.swing.JButton();
        manUnitedLogoLabel = new javax.swing.JLabel();
        ncuPanel = new javax.swing.JPanel();
        ncuPanel.setVisible(false);
        ncuHeadingLabel = new javax.swing.JLabel();
        ncuTeamLabel = new javax.swing.JLabel();
        ncuScheduleLabel = new javax.swing.JLabel();
        ncuJSP = new javax.swing.JScrollPane();
        ncuTable = new javax.swing.JTable();
        ncuBackButton = new javax.swing.JButton();
        ncuLogoLabel = new javax.swing.JLabel();
        norwichPanel = new javax.swing.JPanel();
        norwichPanel.setVisible(false);
        norwichHeadingLabel = new javax.swing.JLabel();
        norwichTeamLabel = new javax.swing.JLabel();
        norwichScheduleLabel = new javax.swing.JLabel();
        norwichJSP = new javax.swing.JScrollPane();
        norwichTable = new javax.swing.JTable();
        norwichBackButton = new javax.swing.JButton();
        norwichLogoLabel = new javax.swing.JLabel();
        sheffieldPanel = new javax.swing.JPanel();
        sheffieldPanel.setVisible(false);
        sheffieldHeadingLabel = new javax.swing.JLabel();
        sheffieldTeamLabel = new javax.swing.JLabel();
        sheffieldScheduleLabel = new javax.swing.JLabel();
        sheffieldJSP = new javax.swing.JScrollPane();
        sheffieldTable = new javax.swing.JTable();
        sheffieldBackButton = new javax.swing.JButton();
        sheffieldLogoLabel = new javax.swing.JLabel();
        southamptonPanel = new javax.swing.JPanel();
        southamptonPanel.setVisible(false);
        southamptonHeadingLabel = new javax.swing.JLabel();
        southamptonTeamLabel = new javax.swing.JLabel();
        southamptonScheduleLabel = new javax.swing.JLabel();
        southamptonJSP = new javax.swing.JScrollPane();
        southamptonTable = new javax.swing.JTable();
        southamptonBackButton = new javax.swing.JButton();
        southamptonLogoLabel = new javax.swing.JLabel();
        tottenhamPanel = new javax.swing.JPanel();
        tottenhamPanel.setVisible(false);
        tottenhamHeadingLabel = new javax.swing.JLabel();
        tottenhamTeamLabel = new javax.swing.JLabel();
        tottenhamScheduleLabel = new javax.swing.JLabel();
        tottenhamJSP = new javax.swing.JScrollPane();
        tottenhamTable = new javax.swing.JTable();
        tottenhamBackButton = new javax.swing.JButton();
        tottenhamLogoLabel = new javax.swing.JLabel();
        watfordPanel = new javax.swing.JPanel();
        watfordPanel.setVisible(false);
        watfordHeadingLevel = new javax.swing.JLabel();
        watfordTeamLabel = new javax.swing.JLabel();
        watfordScheduleLabel = new javax.swing.JLabel();
        watfordJSP = new javax.swing.JScrollPane();
        watfordTable = new javax.swing.JTable();
        watfordBackButton = new javax.swing.JButton();
        watfordLogoLabel = new javax.swing.JLabel();
        whPanel = new javax.swing.JPanel();
        whPanel.setVisible(false);
        whHeadingLevel = new javax.swing.JLabel();
        whTeamLabel = new javax.swing.JLabel();
        whScheduleLabel = new javax.swing.JLabel();
        whJSP = new javax.swing.JScrollPane();
        whTable = new javax.swing.JTable();
        whBackButton = new javax.swing.JButton();
        whLogoLabel = new javax.swing.JLabel();
        wolvesPanel = new javax.swing.JPanel();
        wolvesPanel.setVisible(false);
        wolvesHeadingLevel = new javax.swing.JLabel();
        wolvesTeamLabel = new javax.swing.JLabel();
        wolvesScheduleLabel = new javax.swing.JLabel();
        wolvesJSP = new javax.swing.JScrollPane();
        wolvesTable = new javax.swing.JTable();
        wolvesBackButton = new javax.swing.JButton();
        wolvesLogoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Soccer Scores and Wagers Application");
		getContentPane().setBackground(Color.CYAN);

        loginRegisterButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginRegisterButton.setText("Register");
        loginRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginRegisterButtonActionPerformed(evt);


            }
        });

        loginLoginButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginLoginButton.setText("Login");
        loginLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    loginLoginButtonActionPerformed(evt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        loginPasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginPasswordLabel.setText("Password:");

        loginUsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginUsernameLabel.setText("Username:");

        loginUsernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUsernameTextFieldActionPerformed(evt);
            }
        });

        loginHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginHeadingLabel.setText("Soccer Scores and Wagers");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
		loginPanel.setBackground(Color.CYAN);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, loginPanelLayout.createSequentialGroup()
                                                .addComponent(loginLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loginRegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, loginPanelLayout.createSequentialGroup()
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(loginUsernameLabel)
                                                        .addComponent(loginPasswordLabel))
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                                .addGap(29, 29, 29)
                                                                .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(loginUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(loginHeadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(219, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(loginHeadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginUsernameLabel)
                                        .addComponent(loginUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginPasswordLabel)
                                        .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loginRegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(208, Short.MAX_VALUE))
        );

        registerPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        registerHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerHeadingLabel.setText("Soccer Scores and Wagers");

        registerUsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        registerUsernameLabel.setText("Username:");

        registerPasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        registerPasswordLabel.setText("Password:");

        registerPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPasswordFieldActionPerformed(evt);
            }
        });

        registerRegisterButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registerRegisterButton.setText("Register Account");
        registerRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {
                    registerRegisterButtonActionPerformed(evt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        registerTermsTextArea.setEditable(false);
        registerTermsTextArea.setColumns(20);
        registerTermsTextArea.setRows(5);
        registerTermsTextArea.setText("By registering this account, you are acknowledging\nthat you are of legal age and will comply with all\ngambling regulations in your region.");
        registerTermsJSP.setViewportView(registerTermsTextArea);

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
		registerPanel.setBackground(Color.CYAN);
        registerPanelLayout.setHorizontalGroup(
                registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registerPanelLayout.createSequentialGroup()
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(registerPanelLayout.createSequentialGroup()
                                                .addGap(154, 154, 154)
                                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(registerPanelLayout.createSequentialGroup()
                                                                .addComponent(registerPasswordLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(registerPasswordField))
                                                        .addGroup(registerPanelLayout.createSequentialGroup()
                                                                .addComponent(registerUsernameLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(registerUsernameTextField))
                                                        .addComponent(registerHeadingLabel)
                                                        .addComponent(registerRegisterButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerPanelLayout.createSequentialGroup()
                                                .addGap(153, 153, 153)
                                                .addComponent(registerTermsJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(162, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
                registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(registerHeadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(registerUsernameLabel)
                                        .addComponent(registerUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(registerPasswordLabel)
                                        .addComponent(registerPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(registerRegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(registerTermsJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(124, Short.MAX_VALUE))
        );

        homeHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        homeHeadingLabel.setText("Soccer Scores and Wagers");

        homeUpcomingGamesButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        homeUpcomingGamesButton.setText("View Upcoming Games");
        homeUpcomingGamesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeUpcomingGamesButtonActionPerformed(evt);
            }
        });

        homeScoresButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        homeScoresButton.setText("Scores/Results");
        homeScoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeScoresButtonActionPerformed(evt);
            }
        });

        homeTeamsComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        homeTeamsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select a Team", "Arsenal", "Aston Villa", "Bournemouth", "Brighton", "Burnley", "Chelsea", "Crystal Palace", "Everton", "Leicester City", "Liverpool", "Manchester City", "Manchester United", "Newcastle United", "Norwich City", "Sheffield United", "Southampton", "Tottenham", "Watford", "West Ham", "Wolves"}));

        homeGoButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        homeGoButton.setText("Go");
        homeGoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeGoButtonActionPerformed(evt);
            }
        });

        homeStandingsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Team", "Ranking", "Wins", "Losses", "Draws", "Goals For", "Goals Against"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        homeStandingsTable.getTableHeader().setReorderingAllowed(false);
        homeJSP.setViewportView(homeStandingsTable);

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
		homePanel.setBackground(Color.CYAN);
        homePanelLayout.setHorizontalGroup(
                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homePanelLayout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(homeHeadingLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(homeJSP)
                                        .addGroup(homePanelLayout.createSequentialGroup()
                                                .addComponent(homeUpcomingGamesButton)
                                                .addGap(39, 39, 39)
                                                .addComponent(homeScoresButton)
                                                .addGap(42, 42, 42)
                                                .addComponent(homeTeamsComboBox, 0, 149, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(homeGoButton)))
                                .addGap(26, 26, 26))
        );
        homePanelLayout.setVerticalGroup(
                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(homeHeadingLabel)
                                .addGap(18, 18, 18)
                                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(homeScoresButton)
                                        .addComponent(homeUpcomingGamesButton)
                                        .addComponent(homeTeamsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(homeGoButton))
                                .addGap(18, 18, 18)
                                .addComponent(homeJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(91, Short.MAX_VALUE))
        );

        resultsHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        resultsHeadingLabel.setText("Soccer Scores and Wagers");

        resultsScoresTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Date", "Home Team", "Home Goals", "Away Team", "Away Goals", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        resultsJSP.setViewportView(resultsScoresTable);

        resultsBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resultsBackButton.setText("Back");
        resultsBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultsBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout resultsPanelLayout = new javax.swing.GroupLayout(resultsPanel);
        resultsPanel.setLayout(resultsPanelLayout);
		resultsPanel.setBackground(Color.CYAN);
        resultsPanelLayout.setHorizontalGroup(
                resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(resultsPanelLayout.createSequentialGroup()
                                .addGroup(resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(resultsPanelLayout.createSequentialGroup()
                                                .addGap(154, 154, 154)
                                                .addComponent(resultsHeadingLabel))
                                        .addGroup(resultsPanelLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(resultsJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(resultsBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        resultsPanelLayout.setVerticalGroup(
                resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(resultsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(resultsHeadingLabel)
                                .addGap(18, 18, 18)
                                .addComponent(resultsJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(resultsBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(196, Short.MAX_VALUE))
        );

        upcomingHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        upcomingHeadingLabel.setText("Soccer Scores and Wagers");

        upcomingJCB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        upcomingJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Week 35", "Week 36", "Week 37", "Week 38"}));

        upcomingGoButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        upcomingGoButton.setText("Go");
        upcomingGoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGoButtonActionPerformed(evt);
            }
        });

        upcomingScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Date", "Away Team", "Home Team"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        upcomingScheduleTable.setRowHeight(22);
        upcomingScheduleTable.getTableHeader().setReorderingAllowed(false);
        upcomingJSP.setViewportView(upcomingScheduleTable);

        upcomingBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        upcomingBackButton.setText("Back");
        upcomingBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingBackButtonActionPerformed(evt);
            }
        });

        upcomingGame1Button.setText("Make Wager");
        upcomingGame1Button.setMargin(new java.awt.Insets(0, 14, 0, 14));
        upcomingGame1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGame1ButtonActionPerformed(evt);
            }
        });

        upcomingGame2Button.setText("Make Wager");
        upcomingGame2Button.setMargin(new java.awt.Insets(1, 14, 1, 14));
        upcomingGame2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGame2ButtonActionPerformed(evt);
            }
        });

        upcomingGame3Button.setText("Make Wager");
        upcomingGame3Button.setMargin(new java.awt.Insets(1, 14, 1, 14));
        upcomingGame3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGame3ButtonActionPerformed(evt);
            }
        });

        upcomingGame4Button.setText("Make Wager");
        upcomingGame4Button.setMargin(new java.awt.Insets(1, 14, 1, 14));
        upcomingGame4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGame4ButtonActionPerformed(evt);
            }
        });

        upcomingGame5Button.setText("Make Wager");
        upcomingGame5Button.setMargin(new java.awt.Insets(1, 14, 1, 14));
        upcomingGame5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGame5ButtonActionPerformed(evt);
            }
        });

        upcomingGame6Button.setText("Make Wager");
        upcomingGame6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGame6ButtonActionPerformed(evt);
            }
        });

        upcomingGame7Button.setText("Make Wager");
        upcomingGame7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGame7ButtonActionPerformed(evt);
            }
        });

        upcomingGame8Button.setText("Make Wager");
        upcomingGame8Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGame8ButtonActionPerformed(evt);
            }
        });

        upcomingGame9Button.setText("Make Wager");
        upcomingGame9Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGame9ButtonActionPerformed(evt);
            }
        });

        upcomingGame10Button.setText("Make Wager");
        upcomingGame10Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingGame10ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout upcomingGamesPanelLayout = new javax.swing.GroupLayout(upcomingGamesPanel);
        upcomingGamesPanel.setLayout(upcomingGamesPanelLayout);
		upcomingGamesPanel.setBackground(Color.CYAN);
        upcomingGamesPanelLayout.setHorizontalGroup(
                upcomingGamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(upcomingGamesPanelLayout.createSequentialGroup()
                                .addGroup(upcomingGamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(upcomingGamesPanelLayout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(upcomingGamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(upcomingJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(upcomingBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(upcomingGamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(upcomingGame2Button, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                                        .addComponent(upcomingGame3Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(upcomingGame4Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(upcomingGame5Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(upcomingGame6Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(upcomingGame7Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(upcomingGame8Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(upcomingGame9Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(upcomingGame10Button, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                        .addComponent(upcomingGame1Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(upcomingGamesPanelLayout.createSequentialGroup()
                                                .addGap(152, 152, 152)
                                                .addGroup(upcomingGamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(upcomingGamesPanelLayout.createSequentialGroup()
                                                                .addComponent(upcomingJCB, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(upcomingGoButton))
                                                        .addComponent(upcomingHeadingLabel))))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        upcomingGamesPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{upcomingGame10Button, upcomingGame2Button, upcomingGame3Button, upcomingGame4Button, upcomingGame5Button, upcomingGame6Button, upcomingGame7Button, upcomingGame8Button, upcomingGame9Button});

        upcomingGamesPanelLayout.setVerticalGroup(
                upcomingGamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(upcomingGamesPanelLayout.createSequentialGroup()
                                .addGroup(upcomingGamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(upcomingGamesPanelLayout.createSequentialGroup()
                                                .addGap(127, 127, 127)
                                                .addComponent(upcomingGame1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upcomingGame2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(upcomingGame3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upcomingGame4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upcomingGame5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upcomingGame6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upcomingGame7Button, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upcomingGame8Button, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upcomingGame9Button, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upcomingGame10Button, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(upcomingGamesPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(upcomingHeadingLabel)
                                                .addGap(18, 18, 18)
                                                .addGroup(upcomingGamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(upcomingJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(upcomingGoButton))
                                                .addGap(18, 18, 18)
                                                .addComponent(upcomingJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(upcomingBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
        );

        wagersHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wagersHeadingLabel.setText("Soccer Scores and Wagers");

        wagersTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Away Team", "Home Team", "Over/Under"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        wagersJSP.setViewportView(wagersTable);

        wagersButtonGroup.add(wagersOverRB);
        wagersOverRB.setText("Over");
		wagersOverRB.setSelected(true);

        wagersButtonGroup.add(wagersUnderRB);
        wagersUnderRB.setText("Under");

        wagersBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wagersBackButton.setText("Back");
        wagersBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wagersBackButtonActionPerformed(evt);
            }
        });

        wagersSubmitButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wagersSubmitButton.setText("Submit Wager");
        wagersSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wagersSubmitButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter Wager:");

        javax.swing.GroupLayout wagersPanelLayout = new javax.swing.GroupLayout(wagersPanel);
        wagersPanel.setLayout(wagersPanelLayout);
		wagersPanel.setBackground(Color.CYAN);
        wagersPanelLayout.setHorizontalGroup(
                wagersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(wagersPanelLayout.createSequentialGroup()
                                .addGroup(wagersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(wagersPanelLayout.createSequentialGroup()
                                                .addGap(147, 147, 147)
                                                .addComponent(wagersHeadingLabel))
                                        .addGroup(wagersPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(wagersBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wagersPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(wagersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wagersPanelLayout.createSequentialGroup()
                                                .addComponent(wagersJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addGroup(wagersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(wagersWagerTextField)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                                .addGap(32, 32, 32)
                                                .addGroup(wagersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(wagersOverRB, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(wagersUnderRB))
                                                .addGap(48, 48, 48))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wagersPanelLayout.createSequentialGroup()
                                                .addComponent(wagersSubmitButton)
                                                .addGap(61, 61, 61))))
        );
        wagersPanelLayout.setVerticalGroup(
                wagersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(wagersPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(wagersHeadingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(wagersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(wagersJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(28, 28, 28)
                                .addGroup(wagersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(wagersSubmitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(wagersBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wagersPanelLayout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addComponent(wagersOverRB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(wagersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(wagersUnderRB)
                                        .addComponent(wagersWagerTextField))
                                .addGap(395, 395, 395))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Soccer Scores and Wagers");

        thankYouTextArea.setEditable(false);
        thankYouTextArea.setColumns(20);
        thankYouTextArea.setRows(5);
        thankYouTextArea.setText("Thank you for submitting a wager. You may now safely exit the\napplication or press the Home button to return to the home page.");
        thankYouJSP.setViewportView(thankYouTextArea);

        thankYouHomeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        thankYouHomeButton.setText("Home");
        thankYouHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thankYouHomeButtonActionPerformed(evt);
            }
        });

        thankYouExitButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        thankYouExitButton.setText("Exit");
        thankYouExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thankYouExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout thankYouPanelLayout = new javax.swing.GroupLayout(thankYouPanel);
        thankYouPanel.setLayout(thankYouPanelLayout);
		thankYouPanel.setBackground(Color.CYAN);
        thankYouPanelLayout.setHorizontalGroup(
                thankYouPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(thankYouPanelLayout.createSequentialGroup()
                                .addGroup(thankYouPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(thankYouPanelLayout.createSequentialGroup()
                                                .addGap(160, 160, 160)
                                                .addComponent(jLabel1))
                                        .addGroup(thankYouPanelLayout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addGroup(thankYouPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(thankYouJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(thankYouPanelLayout.createSequentialGroup()
                                                                .addComponent(thankYouHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(thankYouExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        thankYouPanelLayout.setVerticalGroup(
                thankYouPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(thankYouPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(thankYouJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(thankYouPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(thankYouHomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                        .addComponent(thankYouExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(240, Short.MAX_VALUE))
        );

        arsenalHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        arsenalHeadingLabel.setText("Soccer Scores and Wagers");

        arsenalTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        arsenalTeamLabel.setText("Arsenal");

        arsenalScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        arsenalScheduleLabel.setText("Upcoming Schedule");

        arsenalTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sunday 12 July 2020", "Tottenham Hotspur", "Tottenham Hotspur Stadium, London"},
                        {"Wed 15 Jul 2020", "Liverpool", "Emirates Stadium, London"},
                        {"Tue 21 Jul 2020", "Aston Villa", "Villa Park, Birmingham"},
                        {"Sun 26 Jul 2020", "Watford", "Emirates Stadium, London"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        arsenalJSP.setViewportView(arsenalTable);

        arsenalBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        arsenalBackButton.setText("Back");
        arsenalBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arsenalBackButtonActionPerformed(evt);
            }
        });

        arsenalLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/arsenal.png"))); // NOI18N

        javax.swing.GroupLayout arsenalPanelLayout = new javax.swing.GroupLayout(arsenalPanel);
        arsenalPanel.setLayout(arsenalPanelLayout);
		arsenalPanel.setBackground(Color.CYAN);
        arsenalPanelLayout.setHorizontalGroup(
                arsenalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(arsenalPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(arsenalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(arsenalPanelLayout.createSequentialGroup()
                                                .addComponent(arsenalLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(arsenalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(arsenalTeamLabel)
                                                        .addComponent(arsenalHeadingLabel)))
                                        .addComponent(arsenalBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(arsenalScheduleLabel)
                                        .addComponent(arsenalJSP))
                                .addGap(157, 157, 157))
        );
        arsenalPanelLayout.setVerticalGroup(
                arsenalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(arsenalPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(arsenalHeadingLabel)
                                .addGroup(arsenalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(arsenalPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(arsenalTeamLabel))
                                        .addGroup(arsenalPanelLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(arsenalLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(arsenalScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(arsenalJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(arsenalBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(312, Short.MAX_VALUE))
        );

        astonHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        astonHeadingLabel.setText("Soccer Scores and Wagers");

        astonTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        astonTeamLabel.setText("Aston Villa");

        astonScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        astonScheduleLabel.setText("Upcoming Schedule");

        astonTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sun 12 Jul 2020", "Crystal Palace","Villa Park, Birmingham"},
                        {"Thu 16 Jul 2020", "Everton","Goodison Park, Liverpool" },
                        {"Tue 21 Jul 2020", "Arsenal", "Villa Park, Birmingham"},
                        {"Sun 26 Jul 2020", "West Ham United", "London Stadium, London"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        astonJSP.setViewportView(astonTable);

        astonBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        astonBackButton.setText("Back");
        astonBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                astonBackButtonActionPerformed(evt);
            }
        });

        astonLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/aston.png"))); // NOI18N

        javax.swing.GroupLayout astonPanelLayout = new javax.swing.GroupLayout(astonPanel);
        astonPanel.setLayout(astonPanelLayout);
		astonPanel.setBackground(Color.CYAN);
        astonPanelLayout.setHorizontalGroup(
                astonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(astonPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(astonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(astonPanelLayout.createSequentialGroup()
                                                .addGroup(astonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(astonPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(astonHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, astonPanelLayout.createSequentialGroup()
                                                                .addComponent(astonLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(astonTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(astonPanelLayout.createSequentialGroup()
                                                .addGroup(astonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(astonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(astonJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(astonScheduleLabel))
                                                .addContainerGap(118, Short.MAX_VALUE))))
        );
        astonPanelLayout.setVerticalGroup(
                astonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(astonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(astonHeadingLabel)
                                .addGroup(astonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(astonPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(astonTeamLabel)
                                                .addGap(68, 68, 68))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, astonPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(astonLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(astonScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(astonJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(astonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(143, Short.MAX_VALUE))
        );

        bournemouthHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bournemouthHeadingLabel.setText("Soccer Scores and Wagers");

        bournemouthTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        bournemouthTeamLabel.setText("Bournemouth");

        bournemouthScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bournemouthScheduleLabel.setText("Upcoming Schedule");

        bournemouthTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sun 12 Jul 2020", "Leicester City", "Vitality Stadium, Bournemouth"},
                        {"Wed 15 Jul 2020", "Manchester City", "Etihad Stadium, Manchester"},
                        {"Sun 19 Jul 2020", "Southampton", "Vitality Stadium, Bournemouth"},
                        {"Sun 26 Jul 2020", "Everton", "Goodison Park, Liverpool"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        bournemouthJSP.setViewportView(bournemouthTable);

        bournemouthBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bournemouthBackButton.setText("Back");
        bournemouthBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bournemouthBackButtonActionPerformed(evt);
            }
        });

        bournemouthLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/bournemouth.png"))); // NOI18N

        javax.swing.GroupLayout bournemouthPanelLayout = new javax.swing.GroupLayout(bournemouthPanel);
        bournemouthPanel.setLayout(bournemouthPanelLayout);
		bournemouthPanel.setBackground(Color.CYAN);
        bournemouthPanelLayout.setHorizontalGroup(
                bournemouthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bournemouthPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(bournemouthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(bournemouthPanelLayout.createSequentialGroup()
                                                .addGroup(bournemouthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(bournemouthPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(bournemouthHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bournemouthPanelLayout.createSequentialGroup()
                                                                .addComponent(bournemouthLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(bournemouthTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(bournemouthPanelLayout.createSequentialGroup()
                                                .addGroup(bournemouthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bournemouthBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bournemouthJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bournemouthScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        bournemouthPanelLayout.setVerticalGroup(
                bournemouthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bournemouthPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bournemouthHeadingLabel)
                                .addGroup(bournemouthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(bournemouthPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(bournemouthTeamLabel))
                                        .addGroup(bournemouthPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(bournemouthLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(bournemouthScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bournemouthJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bournemouthBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(179, Short.MAX_VALUE))
        );

        brightonHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        brightonHeadingLabel.setText("Soccer Scores and Wagers");

        brightonTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        brightonTeamLabel.setText("Brighton & Hove Albion");

        brightonScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        brightonScheduleLabel.setText("Upcoming Schedule");

        brightonTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sat 11 Jul 2020", "Manchester City", "Amex Stadium, Falmer"},
                        {"Thu 16 Jul 2020", "Southampton", "St. Mary's Stadium, Southampton"},
                        {"Mon 20 Jul 2020", "Newcastle United", "Amex Stadium, Falmer"},
                        {"Sun 26 Jul 2020", "Burnley", "Turf Moor, Burnley"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        brightonJSP.setViewportView(brightonTable);

        brightonBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        brightonBackButton.setText("Back");
        brightonBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brightonBackButtonActionPerformed(evt);
            }
        });

        brightonLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/brighton.png"))); // NOI18N

        javax.swing.GroupLayout brightonPanelLayout = new javax.swing.GroupLayout(brightonPanel);
        brightonPanel.setLayout(brightonPanelLayout);
		brightonPanel.setBackground(Color.CYAN);
        brightonPanelLayout.setHorizontalGroup(
                brightonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(brightonPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(brightonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(brightonPanelLayout.createSequentialGroup()
                                                .addGroup(brightonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(brightonPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(brightonHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, brightonPanelLayout.createSequentialGroup()
                                                                .addComponent(brightonLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(brightonTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(brightonPanelLayout.createSequentialGroup()
                                                .addGroup(brightonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(brightonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(brightonJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(brightonScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        brightonPanelLayout.setVerticalGroup(
                brightonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(brightonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(brightonHeadingLabel)
                                .addGroup(brightonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(brightonPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(brightonTeamLabel))
                                        .addGroup(brightonPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(brightonLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)
                                .addComponent(brightonScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(brightonJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(brightonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(121, Short.MAX_VALUE))
        );

        burnleyHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        burnleyHeadingLabel.setText("Soccer Scores and Wagers");

        burnleyTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        burnleyTeamLabel.setText("Burnley");

        burnleyScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        burnleyScheduleLabel.setText("Upcoming Schedule");

        burnleyTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sat 11 Jul 2020", "Liverpool", "Anfield, Liverpool"},
                        {"Wed 15 Jul 2020", "Wolverhampton", "Turf Moor, Burnley"},
                        {"Sat 18 Jul 2020", "Norwich City", "Carrow Road, Norwich"},
                        {"Sun 26 Jul 2020", "Brighton & Hove Albion", "Turf Moor, Burnley"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        burnleyJSP.setViewportView(burnleyTable);

        burnleyBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        burnleyBackButton.setText("Back");
        burnleyBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                burnleyBackButtonActionPerformed(evt);
            }
        });

        burnleyLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/burnley.png"))); // NOI18N

        javax.swing.GroupLayout burnleyPanelLayout = new javax.swing.GroupLayout(burnleyPanel);
        burnleyPanel.setLayout(burnleyPanelLayout);
		burnleyPanel.setBackground(Color.CYAN);
        burnleyPanelLayout.setHorizontalGroup(
                burnleyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(burnleyPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(burnleyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(burnleyPanelLayout.createSequentialGroup()
                                                .addGroup(burnleyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(burnleyPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(burnleyHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, burnleyPanelLayout.createSequentialGroup()
                                                                .addComponent(burnleyLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(burnleyTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(burnleyPanelLayout.createSequentialGroup()
                                                .addGroup(burnleyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(burnleyBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(burnleyJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(burnleyScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        burnleyPanelLayout.setVerticalGroup(
                burnleyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(burnleyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(burnleyHeadingLabel)
                                .addGroup(burnleyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(burnleyPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(burnleyTeamLabel))
                                        .addGroup(burnleyPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(burnleyLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addComponent(burnleyScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(burnleyJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(burnleyBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(135, Short.MAX_VALUE))
        );

        chelseaHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        chelseaHeadingLabel.setText("Soccer Scores and Wagers");

        chelseaTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        chelseaTeamLabel.setText("Chelsea");

        chelseaScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        chelseaScheduleLabel.setText("Upcoming Schedule");

        chelseaTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sat 11 Jul 2020", "Sheffield", "Bramall Lane, Sheffield"},
                        {"Tue 14 Jul 2020", "Norwich City", "Stamford Bridge, London"},
                        {"Wed 22 Jul 2020", "Liverpool", "Anfield, Liverpool"},
                        {"Sun 26 Jul 2020", "Wolverhampton", "Stamford Bridge, London"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        chelseaJSP.setViewportView(chelseaTable);

        chelseaBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chelseaBackButton.setText("Back");
        chelseaBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chelseaBackButtonActionPerformed(evt);
            }
        });

        chelseaLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/chelsea.png"))); // NOI18N

        javax.swing.GroupLayout chelseaPanelLayout = new javax.swing.GroupLayout(chelseaPanel);
        chelseaPanel.setLayout(chelseaPanelLayout);
		chelseaPanel.setBackground(Color.CYAN);
        chelseaPanelLayout.setHorizontalGroup(
                chelseaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(chelseaPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(chelseaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(chelseaPanelLayout.createSequentialGroup()
                                                .addGroup(chelseaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(chelseaPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(chelseaHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chelseaPanelLayout.createSequentialGroup()
                                                                .addComponent(chelseaLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(chelseaTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(chelseaPanelLayout.createSequentialGroup()
                                                .addGroup(chelseaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(chelseaBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(chelseaJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(chelseaScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        chelseaPanelLayout.setVerticalGroup(
                chelseaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(chelseaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chelseaHeadingLabel)
                                .addGroup(chelseaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(chelseaPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(chelseaTeamLabel))
                                        .addGroup(chelseaPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chelseaLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(45, 45, 45)
                                .addComponent(chelseaScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chelseaJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chelseaBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(124, Short.MAX_VALUE))
        );

        cpHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cpHeadingLabel.setText("Soccer Scores and Wagers");

        cpTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        cpTeamLabel.setText("Crystal Palace");

        cpScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpScheduleLabel.setText("Upcoming Schedule");

        cpTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sun 12 Jul 2020", "Aston Villa", "Villa Park, Birmingham"},
                        {"Thu 16 Jul 2020", "Manchester United", "Selhurst Park, London"},
                        {"Mon 20 Jul 2020", "Wolverhampton", "Molineux Stadium, Wolverhampton"},
                        {"Sun 26 Jul 2020", "Tottenham Hotspur", "Selhurst Park, London"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        cpJSP.setViewportView(cpTable);

        cpBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cpBackButton.setText("Back");
        cpBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpBackButtonActionPerformed(evt);
            }
        });

        cpLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/cp.png"))); // NOI18N

        javax.swing.GroupLayout cpPanelLayout = new javax.swing.GroupLayout(cpPanel);
        cpPanel.setLayout(cpPanelLayout);
		cpPanel.setBackground(Color.CYAN);
        cpPanelLayout.setHorizontalGroup(
                cpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cpPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(cpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cpPanelLayout.createSequentialGroup()
                                                .addGroup(cpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(cpPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(cpHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cpPanelLayout.createSequentialGroup()
                                                                .addComponent(cpLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(cpTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(cpPanelLayout.createSequentialGroup()
                                                .addGroup(cpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cpBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cpJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cpScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        cpPanelLayout.setVerticalGroup(
                cpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cpPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cpHeadingLabel)
                                .addGroup(cpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cpPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(cpTeamLabel))
                                        .addGroup(cpPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cpLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44)
                                .addComponent(cpScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cpJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cpBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(130, Short.MAX_VALUE))
        );

        evertonHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        evertonHeadingLabel.setText("Soccer Scores and Wagers");

        evertonTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        evertonTeamLabel.setText("Everton");

        evertonScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        evertonScheduleLabel.setText("Upcoming Schedule");

        evertonTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sun 12 Jul 2020", "Wolverhampton", "Molineux Stadium, Wolverhampton"},
                        {"Thu 16 Jul 2020", "Ashton Villa", "Goodison Park, Liverpool"},
                        {"Mon 20 Jul 2020", "Sheffield", "Bramall Lane, Sheffield"},
                        {"Sun 26 Jul 2020", "Bournemouth", "Goodison Park, Liverpool"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        evertonJSP.setViewportView(evertonTable);

        evertonBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        evertonBackButton.setText("Back");
        evertonBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evertonBackButtonActionPerformed(evt);
            }
        });

        evertonLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/everton.png"))); // NOI18N

        javax.swing.GroupLayout evertonPanelLayout = new javax.swing.GroupLayout(evertonPanel);
        evertonPanel.setLayout(evertonPanelLayout);
		evertonPanel.setBackground(Color.CYAN);
        evertonPanelLayout.setHorizontalGroup(
                evertonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(evertonPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(evertonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(evertonPanelLayout.createSequentialGroup()
                                                .addGroup(evertonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(evertonPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(evertonHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, evertonPanelLayout.createSequentialGroup()
                                                                .addComponent(evertonLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(evertonTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(evertonPanelLayout.createSequentialGroup()
                                                .addGroup(evertonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(evertonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(evertonJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(evertonScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        evertonPanelLayout.setVerticalGroup(
                evertonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(evertonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(evertonHeadingLabel)
                                .addGroup(evertonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(evertonPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(evertonTeamLabel))
                                        .addGroup(evertonPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(evertonLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addComponent(evertonScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(evertonJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(evertonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(132, Short.MAX_VALUE))
        );

        lcHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lcHeadingLabel.setText("Soccer Scores and Wagers");

        lcTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lcTeamLabel.setText("Leicester City");

        lcScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lcScheduleLabel.setText("Upcoming Schedule");

        lcTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sun 12 Jul 2020", "Bournemouth", "Vitality Stadium, Bournemouth"},
                        {"Thu 16 Jul 2020", "Sheffield United", "King Power Stadium, Leicester"},
                        {"Sun 19 Jul 2020", "Tottenham Hotspur", "Tottenham Hotspur Stadium, London"},
                        {"Sun 26 Jul 2020", "Manchester United", "King Power Stadium, Leicester"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        lcJSP.setViewportView(lcTable);

        lcBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lcBackButton.setText("Back");
        lcBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lcBackButtonActionPerformed(evt);
            }
        });

        lcLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/lc.png"))); // NOI18N

        javax.swing.GroupLayout lcPanelLayout = new javax.swing.GroupLayout(lcPanel);
        lcPanel.setLayout(lcPanelLayout);
		lcPanel.setBackground(Color.CYAN);
        lcPanelLayout.setHorizontalGroup(
                lcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lcPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(lcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(lcPanelLayout.createSequentialGroup()
                                                .addGroup(lcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(lcPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(lcHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lcPanelLayout.createSequentialGroup()
                                                                .addComponent(lcLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(lcTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(lcPanelLayout.createSequentialGroup()
                                                .addGroup(lcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lcBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lcJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lcScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        lcPanelLayout.setVerticalGroup(
                lcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lcPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lcHeadingLabel)
                                .addGroup(lcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(lcPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(lcTeamLabel))
                                        .addGroup(lcPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lcLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(56, 56, 56)
                                .addComponent(lcScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lcJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lcBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(106, Short.MAX_VALUE))
        );

        liverpoolHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        liverpoolHeadingLabel.setText("Soccer Scores and Wagers");

        liverpoolTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        liverpoolTeamLabel.setText("Liverpool");

        liverpoolScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        liverpoolScheduleLabel.setText("Upcoming Schedule");

        liverpoolTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sat 11 Jul 2020", "Burnley", "Anfield, Liverpool"},
                        {"Wed 15 Jul 2020", "Arsenal", "Emirates Stadium, London"},
                        {"Wed 22 Jul 2020", "Chelsea", "Anfield, Liverpool"},
                        {"Sun 26 Jul 2020", "NewCastle United", "St. James' Park, Newcastle"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        liverpoolJSP.setViewportView(liverpoolTable);

        liverpoolBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        liverpoolBackButton.setText("Back");
        liverpoolBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liverpoolBackButtonActionPerformed(evt);
            }
        });

        liverpoolLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/liverpool.png"))); // NOI18N

        javax.swing.GroupLayout liverpoolPanelLayout = new javax.swing.GroupLayout(liverpoolPanel);
        liverpoolPanel.setLayout(liverpoolPanelLayout);
		liverpoolPanel.setBackground(Color.CYAN);
        liverpoolPanelLayout.setHorizontalGroup(
                liverpoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(liverpoolPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(liverpoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(liverpoolPanelLayout.createSequentialGroup()
                                                .addGroup(liverpoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(liverpoolPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(liverpoolHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, liverpoolPanelLayout.createSequentialGroup()
                                                                .addComponent(liverpoolLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(liverpoolTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(liverpoolPanelLayout.createSequentialGroup()
                                                .addGroup(liverpoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(liverpoolBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(liverpoolJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(liverpoolScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        liverpoolPanelLayout.setVerticalGroup(
                liverpoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(liverpoolPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(liverpoolHeadingLabel)
                                .addGroup(liverpoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(liverpoolPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(liverpoolTeamLabel))
                                        .addGroup(liverpoolPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(liverpoolLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47)
                                .addComponent(liverpoolScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(liverpoolJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(liverpoolBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(115, Short.MAX_VALUE))
        );

        manCityHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manCityHeadingLabel.setText("Soccer Scores and Wagers");

        manCityTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        manCityTeamLabel.setText("Manchester City");

        manCityScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        manCityScheduleLabel.setText("Upcoming Schedule");

        manCityTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sat 11 Jul 2020", "Brighton & Hove Albion", "Amex Stadium, Falmer"},
                        {"Wed 15 Jul 2020", "Bournemouth", "Etihad Stadium, Manchester"},
                        {"Tue 21 Jul 2020", "Watford", "Vicarage Road, Watford"},
                        {"Sun 26 Jul 2020", "Norwich City", "Etihad Stadium, Manchester"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        manCityJSP.setViewportView(manCityTable);

        manCityBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manCityBackButton.setText("Back");
        manCityBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manCityBackButtonActionPerformed(evt);
            }
        });

        manCityLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/manCity.png"))); // NOI18N

        javax.swing.GroupLayout manCityPanelLayout = new javax.swing.GroupLayout(manCityPanel);
        manCityPanel.setLayout(manCityPanelLayout);
		manCityPanel.setBackground(Color.CYAN);
        manCityPanelLayout.setHorizontalGroup(
                manCityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manCityPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(manCityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(manCityPanelLayout.createSequentialGroup()
                                                .addGroup(manCityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(manCityPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(manCityHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manCityPanelLayout.createSequentialGroup()
                                                                .addComponent(manCityLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(manCityTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(manCityPanelLayout.createSequentialGroup()
                                                .addGroup(manCityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(manCityBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(manCityJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(manCityScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        manCityPanelLayout.setVerticalGroup(
                manCityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manCityPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(manCityHeadingLabel)
                                .addGroup(manCityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(manCityPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(manCityTeamLabel))
                                        .addGroup(manCityPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(manCityLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addComponent(manCityScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(manCityJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(manCityBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(130, Short.MAX_VALUE))
        );

        manUnitedHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manUnitedHeadingLabel.setText("Soccer Scores and Wagers");

        manUnitedTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        manUnitedTeamLabel.setText("Manchester United");

        manUnitedScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        manUnitedScheduleLabel.setText("Upcoming Schedule");

        manUnitedTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Mon 13 Jul 2020", "Southhampton", "Old Trafford, Manchester"},
                        {"Thu 16 Jul 2020", "Crystal Palace", "Selhurst Park, London"},
                        {"Wed 22 Jul 2020", "West Ham United", "Old Trafford, Manchester"},
                        {"Sun 26 Jul 2020", "Leicester City", "King Power Stadium, Leicester"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        manUnitedJSP.setViewportView(manUnitedTable);

        manUnitedBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manUnitedBackButton.setText("Back");
        manUnitedBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manUnitedBackButtonActionPerformed(evt);
            }
        });

        manUnitedLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/manUnited.png"))); // NOI18N

        javax.swing.GroupLayout manUnitedPanelLayout = new javax.swing.GroupLayout(manUnitedPanel);
        manUnitedPanel.setLayout(manUnitedPanelLayout);
		manUnitedPanel.setBackground(Color.CYAN);
        manUnitedPanelLayout.setHorizontalGroup(
                manUnitedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manUnitedPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(manUnitedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(manUnitedPanelLayout.createSequentialGroup()
                                                .addGroup(manUnitedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(manUnitedPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(manUnitedHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manUnitedPanelLayout.createSequentialGroup()
                                                                .addComponent(manUnitedLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(manUnitedTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(manUnitedPanelLayout.createSequentialGroup()
                                                .addGroup(manUnitedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(manUnitedBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(manUnitedJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(manUnitedScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        manUnitedPanelLayout.setVerticalGroup(
                manUnitedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manUnitedPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(manUnitedHeadingLabel)
                                .addGroup(manUnitedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(manUnitedPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(manUnitedTeamLabel))
                                        .addGroup(manUnitedPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(manUnitedLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(37, 37, 37)
                                .addComponent(manUnitedScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(manUnitedJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(manUnitedBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(132, Short.MAX_VALUE))
        );

        ncuHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ncuHeadingLabel.setText("Soccer Scores and Wagers");

        ncuTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ncuTeamLabel.setText("Newcastle United");

        ncuScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ncuScheduleLabel.setText("Upcoming Schedule");

        ncuTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sat 11 Jul 2020", "Watford", "Vicarage Road, Watford"},
                        {"Wed 15 Jul 2020", "Tottenham Hotspur", "St. James' Park, Newcastle"},
                        {"Mon 20 Jul 2020", "Brighton and Hove Albion", "Amex Stadium, Falmer"},
                        {"Sun 26 Jul 2020", "Liverpool", "St. James' Park, Newcastle"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        ncuJSP.setViewportView(ncuTable);

        ncuBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ncuBackButton.setText("Back");
        ncuBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncuBackButtonActionPerformed(evt);
            }
        });

        ncuLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/newcastle.png"))); // NOI18N

        javax.swing.GroupLayout ncuPanelLayout = new javax.swing.GroupLayout(ncuPanel);
        ncuPanel.setLayout(ncuPanelLayout);
		ncuPanel.setBackground(Color.CYAN);
        ncuPanelLayout.setHorizontalGroup(
                ncuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ncuPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(ncuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ncuPanelLayout.createSequentialGroup()
                                                .addGroup(ncuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(ncuPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(ncuHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ncuPanelLayout.createSequentialGroup()
                                                                .addComponent(ncuLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(ncuTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(ncuPanelLayout.createSequentialGroup()
                                                .addGroup(ncuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ncuBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ncuJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ncuScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        ncuPanelLayout.setVerticalGroup(
                ncuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ncuPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ncuHeadingLabel)
                                .addGroup(ncuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ncuPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(ncuTeamLabel))
                                        .addGroup(ncuPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(ncuLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addComponent(ncuScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ncuJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ncuBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(135, Short.MAX_VALUE))
        );

        norwichHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        norwichHeadingLabel.setText("Soccer Scores and Wagers");

        norwichTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        norwichTeamLabel.setText("Norwich City");

        norwichScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        norwichScheduleLabel.setText("Upcoming Schedule");

        norwichTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sat 11 Jul 2020", "West Ham United", "Carrow Road, Norwich"},
                        {"Tue 14 Jul 2020", "Chelsea", "Stamford Bridge, London"},
                        {"Sat 18 Jul 2020", "Burnley", "Carrow Road, Norwich"},
                        {"Sun 26 Jul 2020", "Manchester City", "Etihad Stadium, Manchester"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        norwichJSP.setViewportView(norwichTable);

        norwichBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        norwichBackButton.setText("Back");
        norwichBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                norwichBackButtonActionPerformed(evt);
            }
        });

        norwichLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/norwich.png"))); // NOI18N

        javax.swing.GroupLayout norwichPanelLayout = new javax.swing.GroupLayout(norwichPanel);
        norwichPanel.setLayout(norwichPanelLayout);
		norwichPanel.setBackground(Color.CYAN);
        norwichPanelLayout.setHorizontalGroup(
                norwichPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(norwichPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(norwichPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(norwichPanelLayout.createSequentialGroup()
                                                .addGroup(norwichPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(norwichPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(norwichHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, norwichPanelLayout.createSequentialGroup()
                                                                .addComponent(norwichLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(norwichTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(norwichPanelLayout.createSequentialGroup()
                                                .addGroup(norwichPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(norwichBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(norwichJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(norwichScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        norwichPanelLayout.setVerticalGroup(
                norwichPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(norwichPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(norwichHeadingLabel)
                                .addGroup(norwichPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(norwichPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(norwichTeamLabel))
                                        .addGroup(norwichPanelLayout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(norwichLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(norwichScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(norwichJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(norwichBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(190, Short.MAX_VALUE))
        );

        sheffieldHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        sheffieldHeadingLabel.setText("Soccer Scores and Wagers");

        sheffieldTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        sheffieldTeamLabel.setText("Sheffield United");

        sheffieldScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sheffieldScheduleLabel.setText("Upcoming Schedule");

        sheffieldTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sat 11 Jul 2020", "Chelsea", "Bramall Lane, Sheffield"},
                        {"Thu 16 Jul 2020", "Leicester City", "King Power Stadium, Leicester"},
                        {"Mon 20 Jul 2020", "Everton", "Bramall Lane, Sheffield"},
                        {"Sun 26 Jul 2020", "Southampton", "St. Mary's Stadium, Southampton"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        sheffieldJSP.setViewportView(sheffieldTable);

        sheffieldBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sheffieldBackButton.setText("Back");
        sheffieldBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sheffieldBackButtonActionPerformed(evt);
            }
        });

        sheffieldLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/sheffield.png"))); // NOI18N

        javax.swing.GroupLayout sheffieldPanelLayout = new javax.swing.GroupLayout(sheffieldPanel);
        sheffieldPanel.setLayout(sheffieldPanelLayout);
		sheffieldPanel.setBackground(Color.CYAN);
        sheffieldPanelLayout.setHorizontalGroup(
                sheffieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sheffieldPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(sheffieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(sheffieldPanelLayout.createSequentialGroup()
                                                .addGroup(sheffieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(sheffieldPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(sheffieldHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sheffieldPanelLayout.createSequentialGroup()
                                                                .addComponent(sheffieldLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(sheffieldTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(sheffieldPanelLayout.createSequentialGroup()
                                                .addGroup(sheffieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(sheffieldBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sheffieldJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sheffieldScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        sheffieldPanelLayout.setVerticalGroup(
                sheffieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sheffieldPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sheffieldHeadingLabel)
                                .addGroup(sheffieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(sheffieldPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(sheffieldTeamLabel))
                                        .addGroup(sheffieldPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(sheffieldLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(sheffieldScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sheffieldJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sheffieldBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(183, Short.MAX_VALUE))
        );

        southamptonHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        southamptonHeadingLabel.setText("Soccer Scores and Wagers");

        southamptonTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        southamptonTeamLabel.setText("Southampton");

        southamptonScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        southamptonScheduleLabel.setText("Upcoming Schedule");

        southamptonTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Mon 13 Jul 2020", "Manchester United", "Old Trafford, Manchester"},
                        {"Thu 16 Jul 2020", "Brighton and Hove Albion", "St. Mary's Stadium, Southampton"},
                        {"Mon 20 Jul 2020", "Everton", "Bramall Lane, Sheffield"},
                        {"Sun 26 Jul 2020", "Sheffield United", "St. Mary's Stadium, Southampton"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        southamptonJSP.setViewportView(southamptonTable);

        southamptonBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        southamptonBackButton.setText("Back");
        southamptonBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                southamptonBackButtonActionPerformed(evt);
            }
        });

        southamptonLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/southampton.png"))); // NOI18N

        javax.swing.GroupLayout southamptonPanelLayout = new javax.swing.GroupLayout(southamptonPanel);
        southamptonPanel.setLayout(southamptonPanelLayout);
		southamptonPanel.setBackground(Color.CYAN);
        southamptonPanelLayout.setHorizontalGroup(
                southamptonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(southamptonPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(southamptonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(southamptonPanelLayout.createSequentialGroup()
                                                .addGroup(southamptonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(southamptonPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(southamptonHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, southamptonPanelLayout.createSequentialGroup()
                                                                .addComponent(southamptonLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(southamptonTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(southamptonPanelLayout.createSequentialGroup()
                                                .addGroup(southamptonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(southamptonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(southamptonJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(southamptonScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        southamptonPanelLayout.setVerticalGroup(
                southamptonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(southamptonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(southamptonHeadingLabel)
                                .addGroup(southamptonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(southamptonPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(southamptonTeamLabel))
                                        .addGroup(southamptonPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(southamptonLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(southamptonScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(southamptonJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(southamptonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(193, Short.MAX_VALUE))
        );

        tottenhamHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tottenhamHeadingLabel.setText("Soccer Scores and Wagers");

        tottenhamTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tottenhamTeamLabel.setText("Tottenham Hotspur");

        tottenhamScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tottenhamScheduleLabel.setText("Upcoming Schedule");

        tottenhamTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sun 12 Jul 2020", "Arsenal", "Tottenham Hotspur Stadium, London"},
                        {"Wed 15 Jul 2020", "Newcastle United", "St. James' Park, Newcastle"},
                        {"Sun 19 Jul 2020", "Leicester City", "Tottenham Hotspur Stadium, London"},
                        {"Sun 26 Jul 2020", "Crystal Palace", "Selhurst Park, London"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tottenhamJSP.setViewportView(tottenhamTable);

        tottenhamBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tottenhamBackButton.setText("Back");
        tottenhamBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tottenhamBackButtonActionPerformed(evt);
            }
        });

        tottenhamLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/tottenham.png"))); // NOI18N

        javax.swing.GroupLayout tottenhamPanelLayout = new javax.swing.GroupLayout(tottenhamPanel);
        tottenhamPanel.setLayout(tottenhamPanelLayout);
		tottenhamPanel.setBackground(Color.CYAN);
        tottenhamPanelLayout.setHorizontalGroup(
                tottenhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tottenhamPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(tottenhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(tottenhamPanelLayout.createSequentialGroup()
                                                .addGroup(tottenhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(tottenhamPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(tottenhamHeadingLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tottenhamPanelLayout.createSequentialGroup()
                                                                .addComponent(tottenhamLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(tottenhamTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(tottenhamPanelLayout.createSequentialGroup()
                                                .addGroup(tottenhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tottenhamBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tottenhamJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tottenhamScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        tottenhamPanelLayout.setVerticalGroup(
                tottenhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tottenhamPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tottenhamHeadingLabel)
                                .addGroup(tottenhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(tottenhamPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(tottenhamTeamLabel))
                                        .addGroup(tottenhamPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tottenhamLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)
                                .addComponent(tottenhamScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tottenhamJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tottenhamBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(136, Short.MAX_VALUE))
        );

        watfordHeadingLevel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        watfordHeadingLevel.setText("Soccer Scores and Wagers");

        watfordTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        watfordTeamLabel.setText("Watford");

        watfordScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        watfordScheduleLabel.setText("Upcoming Schedule");

        watfordTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sat 11 Jul 2020", "Newcastle United", "Vicarage Road, Watford"},
                        {"Fri 17 Jul 2020", "West Ham United", "London Stadium, London"},
                        {"Tue 21 Jul 2020", "Manchester City","Vicarage Road, Watford"},
                        {"Sun 26 Jul 2020", "Arsenal", "Emirates Stadium, London"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        watfordJSP.setViewportView(watfordTable);

        watfordBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        watfordBackButton.setText("Back");
        watfordBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watfordBackButtonActionPerformed(evt);
            }
        });

        watfordLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/watford.png"))); // NOI18N

        javax.swing.GroupLayout watfordPanelLayout = new javax.swing.GroupLayout(watfordPanel);
        watfordPanel.setLayout(watfordPanelLayout);
		watfordPanel.setBackground(Color.CYAN);
        watfordPanelLayout.setHorizontalGroup(
                watfordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(watfordPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(watfordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(watfordPanelLayout.createSequentialGroup()
                                                .addGroup(watfordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(watfordPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(watfordHeadingLevel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, watfordPanelLayout.createSequentialGroup()
                                                                .addComponent(watfordLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(watfordTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(watfordPanelLayout.createSequentialGroup()
                                                .addGroup(watfordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(watfordBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(watfordJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(watfordScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        watfordPanelLayout.setVerticalGroup(
                watfordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(watfordPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(watfordHeadingLevel)
                                .addGroup(watfordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(watfordPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(watfordTeamLabel))
                                        .addGroup(watfordPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(watfordLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addComponent(watfordScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(watfordJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(watfordBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(127, Short.MAX_VALUE))
        );

        whHeadingLevel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        whHeadingLevel.setText("Soccer Scores and Wagers");

        whTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        whTeamLabel.setText("West Ham United");

        whScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        whScheduleLabel.setText("Upcoming Schedule");

        whTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sat 11 Jul 2020", "Norwich City", "Carrow Road, Norwich"},
                        {"Fri 17 Jul 2020", "Watford", "London Stadium, London"},
                        {"Wed 22 Jul 2020", "Manchester United", "Old Trafford, Manchester"},
                        {"Sun 26 Jul 2020", "Aston Villa", "London Stadium, London"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        whJSP.setViewportView(whTable);

        whBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        whBackButton.setText("Back");
        whBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whBackButtonActionPerformed(evt);
            }
        });

        whLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/wh.png"))); // NOI18N

        javax.swing.GroupLayout whPanelLayout = new javax.swing.GroupLayout(whPanel);
        whPanel.setLayout(whPanelLayout);
		whPanel.setBackground(Color.CYAN);
        whPanelLayout.setHorizontalGroup(
                whPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(whPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(whPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(whPanelLayout.createSequentialGroup()
                                                .addGroup(whPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(whPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(whHeadingLevel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whPanelLayout.createSequentialGroup()
                                                                .addComponent(whLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(whTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(whPanelLayout.createSequentialGroup()
                                                .addGroup(whPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(whBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(whJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(whScheduleLabel))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        whPanelLayout.setVerticalGroup(
                whPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(whPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(whHeadingLevel)
                                .addGroup(whPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(whPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(whTeamLabel))
                                        .addGroup(whPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(whLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29)
                                .addComponent(whScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(whJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(whBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(140, Short.MAX_VALUE))
        );

        wolvesHeadingLevel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wolvesHeadingLevel.setText("Soccer Scores and Wagers");

        wolvesTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        wolvesTeamLabel.setText("Wolverhampton Wanderers");

        wolvesScheduleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        wolvesScheduleLabel.setText("Upcoming Schedule");

        wolvesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Sun 12 Jul 2020", "Everton", "Molineux Stadium, Wolverhampton"},
                        {"Wed 15 Jul 2020", "Burnley", "Turf Moor, Burnley"},
                        {"Mon 20 Jul 2020", "Crystal Palace", "Molineux Stadium, Wolverhampton"},
                        {"Sun 26 Jul 2020", "Chelsea", "Stamford Bridge, London"}
                },
                new String[]{
                        "Date", "Opponent", "Venue"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        wolvesJSP.setViewportView(wolvesTable);

        wolvesBackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wolvesBackButton.setText("Back");
        wolvesBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wolvesBackButtonActionPerformed(evt);
            }
        });

        wolvesLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SSWGUI/wolves.png"))); // NOI18N

        javax.swing.GroupLayout wolvesPanelLayout = new javax.swing.GroupLayout(wolvesPanel);
        wolvesPanel.setLayout(wolvesPanelLayout);
		wolvesPanel.setBackground(Color.CYAN);
        wolvesPanelLayout.setHorizontalGroup(
                wolvesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(wolvesPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(wolvesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(wolvesPanelLayout.createSequentialGroup()
                                                .addGroup(wolvesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(wolvesPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                                                .addComponent(wolvesHeadingLevel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wolvesPanelLayout.createSequentialGroup()
                                                                .addComponent(wolvesLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(wolvesTeamLabel)))
                                                .addGap(157, 157, 157))
                                        .addGroup(wolvesPanelLayout.createSequentialGroup()
                                                .addGroup(wolvesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(wolvesBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(wolvesJSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(wolvesScheduleLabel))
                                                .addContainerGap(118, Short.MAX_VALUE))))
        );
        wolvesPanelLayout.setVerticalGroup(
                wolvesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(wolvesPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(wolvesHeadingLevel)
                                .addGroup(wolvesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(wolvesPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(wolvesTeamLabel))
                                        .addGroup(wolvesPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(wolvesLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addComponent(wolvesScheduleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(wolvesJSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(wolvesBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(resultsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(upcomingGamesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(wagersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(thankYouPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 29, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(arsenalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(astonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bournemouthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(brightonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(burnleyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(chelseaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(evertonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lcPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(liverpoolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(manCityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(manUnitedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ncuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(norwichPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(sheffieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(southamptonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tottenhamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(watfordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(whPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(wolvesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 30, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(9809, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 4904, Short.MAX_VALUE)
                                        .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 4905, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 4845, Short.MAX_VALUE)
                                        .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 4845, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 4866, Short.MAX_VALUE)
                                        .addComponent(resultsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 4867, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 4865, Short.MAX_VALUE)
                                        .addComponent(upcomingGamesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 4865, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 4872, Short.MAX_VALUE)
                                        .addComponent(wagersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 4873, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 4904, Short.MAX_VALUE)
                                        .addComponent(thankYouPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 4905, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(arsenalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(astonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(brightonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(burnleyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(chelseaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(cpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(evertonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lcPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(liverpoolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(manCityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(manUnitedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(ncuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(norwichPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(sheffieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(southamptonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(tottenhamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(watfordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(whPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(wolvesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(bournemouthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginUsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUsernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUsernameTextFieldActionPerformed

    private void loginLoginButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_loginLoginButtonActionPerformed
        String username = loginUsernameTextField.getText();
        String password = String.valueOf(loginPasswordField.getPassword());
        try {
            ps = conn.dbConnection().prepareStatement("SELECT * FROM user_login WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "User " + username + " is Logged in","User Login",2);
				sessionUserName = username;
                homePanel.setVisible(true);
                loginPanel.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Username or password", "Login Failed", 2);
                loginPanel.setVisible(true);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }//GEN-LAST:event_loginLoginButtonActionPerformed

    private void loginRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginRegisterButtonActionPerformed

        loginPanel.setVisible(false);
        registerPanel.setVisible(true);
    }//GEN-LAST:event_loginRegisterButtonActionPerformed

    private void registerPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPasswordFieldActionPerformed

    private void registerRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_registerRegisterButtonActionPerformed
        String username = registerUsernameTextField.getText();
        String password = String.valueOf(registerPasswordField.getPassword());
        userCheck check = new userCheck();

        if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter a Username");
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter a Password");
        } else if (check.checkUserName(username)) {
            JOptionPane.showMessageDialog(null, "This Username Already Exists");
        }
        try {
            ps = conn.dbConnection().prepareStatement("INSERT INTO user_login(username, password) VALUES (?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            if (ps.executeUpdate() > 0) {
                sessionUserName = username;
				JOptionPane.showMessageDialog(null, "New User Added","User Registration",2);
            }
        } catch (SQLException throwables) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, throwables);
        }
        registerPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_registerRegisterButtonActionPerformed

    private void resultsBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultsBackButtonActionPerformed
        resultsPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_resultsBackButtonActionPerformed

    private void homeUpcomingGamesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeUpcomingGamesButtonActionPerformed
        homePanel.setVisible(false);
        upcomingGamesPanel.setVisible(true);
    }//GEN-LAST:event_homeUpcomingGamesButtonActionPerformed

    private void homeScoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeScoresButtonActionPerformed
        homePanel.setVisible(false);
        resultsPanel.setVisible(true);
    }//GEN-LAST:event_homeScoresButtonActionPerformed

    private void wagersBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wagersBackButtonActionPerformed
        wagersPanel.setVisible(false);
        upcomingGamesPanel.setVisible(true);
    }//GEN-LAST:event_wagersBackButtonActionPerformed

    private void wagersSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wagersSubmitButtonActionPerformed
                double wagerCheck = 0; // This is used to catch non whole number wagers
                int wagerAmount; // This is the actual verified wager amount that will be inserted to the table
		String overUnderSelection;
		DefaultTableModel model = (DefaultTableModel) wagersTable.getModel();
		String homeTeam = (String) model.getValueAt(0,1);
		String awayTeam = (String) model.getValueAt(0,0);
		if(wagersOverRB.isSelected()) {
			overUnderSelection = "Over";
		} else {
			overUnderSelection = "Under";
		}
                // Try/Catch statement for handling both SQL exception and number format exception for user input
                try{
                    wagerCheck = Double.parseDouble(wagersWagerTextField.getText());
                
                    // % operator to check for remainder when dividing by 1
                    // if there is a remainder, the input must not be a whole number
                    // and an error message will appear informing the user of the mistake
                    if((wagerCheck % 1) == 0){
                        wagerAmount = (int) wagerCheck;
       
                        ps = conn.dbConnection().prepareStatement("INSERT INTO wagers(user_name, wager_amount, over_under, home_team, away_team) VALUES (?,?,?,?,?)");
                        ps.setString(1, sessionUserName);
                        ps.setInt(2, wagerAmount);
                        ps.setString(3, overUnderSelection);
                        ps.setString(4, homeTeam);
                        ps.setString(5, awayTeam);
                            if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Wager has been submitted, thank you!");
                            }
                        wagersPanel.setVisible(false);
                        thankYouPanel.setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null, "Wager must be a whole number");
                                }
                    } catch (SQLException throwables) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, throwables);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Wager must be a number.");
                    }
    }//GEN-LAST:event_wagersSubmitButtonActionPerformed

    private void thankYouExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thankYouExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_thankYouExitButtonActionPerformed

    private void thankYouHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thankYouHomeButtonActionPerformed
        thankYouPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_thankYouHomeButtonActionPerformed

    private void upcomingBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingBackButtonActionPerformed
        upcomingGamesPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_upcomingBackButtonActionPerformed

    private void upcomingGoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGoButtonActionPerformed
        int selection = upcomingJCB.getSelectedIndex();
        switch (selection){
            case 0:
                showUpcomingWeek35();
                break;
            case 1:
                showUpcomingWeek36();
                break;
            case 2:
                showUpcomingWeek37();
                break;
            case 3:
                showUpcomingWeek38();
                break;
            default:
                break;
        }

    }//GEN-LAST:event_upcomingGoButtonActionPerformed

    private void upcomingGame1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGame1ButtonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) upcomingScheduleTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) wagersTable.getModel();
        OverUnderFormula o = new OverUnderFormula();
        Object result = o.OverUnderCalc(56,48,18649,406,147,
                                        36,64,18549,406,147);
        Object[] row = new Object[2];
        model2.setRowCount(0);
        row[0] = model1.getValueAt(0,1);
        row[1] = model1.getValueAt(0,2);
        model2.addRow(row);
        model2.setValueAt(result,0,2);
        upcomingGamesPanel.setVisible(false);
        wagersPanel.setVisible(true);
    }//GEN-LAST:event_upcomingGame1ButtonActionPerformed

    private void upcomingGame2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGame2ButtonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) upcomingScheduleTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) wagersTable.getModel();
        OverUnderFormula o = new OverUnderFormula();
        Object result = o.OverUnderCalc(43,50,12814,387,120,
                                        39,54,18188,462,117);
        Object[] row = new Object[2];
        model2.setRowCount(0);
        row[0] = model1.getValueAt(1,1);
        row[1] = model1.getValueAt(1,2);
        model2.addRow(row);
        model2.setValueAt(result,0,2);
        upcomingGamesPanel.setVisible(false);
        wagersPanel.setVisible(true);
    }//GEN-LAST:event_upcomingGame2ButtonActionPerformed

    private void upcomingGame3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGame3ButtonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) upcomingScheduleTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) wagersTable.getModel();
        OverUnderFormula o = new OverUnderFormula();
        Object result = o.OverUnderCalc(69,54,23244,625,65,
                                52,40,16764,461,91);
        Object[] row = new Object[2];
        model2.setRowCount(0);
        row[0] = model1.getValueAt(2,1);
        row[1] = model1.getValueAt(2,2);
        model2.addRow(row);
        model2.setValueAt(result,0,2);
        upcomingGamesPanel.setVisible(false);
        wagersPanel.setVisible(true);
    }//GEN-LAST:event_upcomingGame3ButtonActionPerformed

    private void upcomingGame4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGame4ButtonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) upcomingScheduleTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) wagersTable.getModel();
        OverUnderFormula o = new OverUnderFormula();
        Object result = o.OverUnderCalc(31,50,14688,376,126,
                61,47,16644,444,140);
        Object[] row = new Object[2];
        model2.setRowCount(0);
        row[0] = model1.getValueAt(3,1);
        row[1] = model1.getValueAt(3,2);
        model2.addRow(row);
        model2.setValueAt(result,0,2);
        upcomingGamesPanel.setVisible(false);
        wagersPanel.setVisible(true);
    }//GEN-LAST:event_upcomingGame4ButtonActionPerformed

    private void upcomingGame5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGame5ButtonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) upcomingScheduleTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) wagersTable.getModel();
        OverUnderFormula o = new OverUnderFormula();
        Object result = o.OverUnderCalc(44,56,15826,469,95,
                44,56,15826,469,95);
        Object[] row = new Object[2];
        model2.setRowCount(0);
        row[0] = model1.getValueAt(4,1);
        row[1] = model1.getValueAt(4,2);
        model2.addRow(row);
        model2.setValueAt(result,0,2);
        upcomingGamesPanel.setVisible(false);
        wagersPanel.setVisible(true);
    }//GEN-LAST:event_upcomingGame5ButtonActionPerformed

    private void upcomingGame6ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGame6ButtonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) upcomingScheduleTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) wagersTable.getModel();
        OverUnderFormula o = new OverUnderFormula();
        Object result = o.OverUnderCalc(67,43,19915,540,96,
                66,36,20059,544,96);
        Object[] row = new Object[3];
        model2.setRowCount(0);
        row[0] = model1.getValueAt(5,1);
        row[1] = model1.getValueAt(5,2);
        model2.addRow(row);
        model2.setValueAt(result,0,2);
        upcomingGamesPanel.setVisible(false);
        wagersPanel.setVisible(true);
    }//GEN-LAST:event_upcomingGame6ButtonActionPerformed

    private void upcomingGame7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGame7ButtonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) upcomingScheduleTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) wagersTable.getModel();
        OverUnderFormula o = new OverUnderFormula();
        Object result = o.OverUnderCalc(102,35,26392,745,76,
                26,75,17362,409,140);
        Object[] row = new Object[2];
        model2.setRowCount(0);
        row[0] = model1.getValueAt(6,1);
        row[1] = model1.getValueAt(6,2);
        model2.addRow(row);
        model2.setValueAt(result,0,2);
        upcomingGamesPanel.setVisible(false);
        wagersPanel.setVisible(true);
    }//GEN-LAST:event_upcomingGame7ButtonActionPerformed

    private void upcomingGame8ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGame8ButtonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) upcomingScheduleTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) wagersTable.getModel();
        OverUnderFormula o = new OverUnderFormula();
        Object result = o.OverUnderCalc(38,58,13066,399,140,
                85,33,23872,591,76);
        Object[] row = new Object[2];
        model2.setRowCount(0);
        row[0] = model1.getValueAt(7,1);
        row[1] = model1.getValueAt(7,2);
        model2.addRow(row);
        model2.setValueAt(result,0,2);
        upcomingGamesPanel.setVisible(false);
        wagersPanel.setVisible(true);
    }//GEN-LAST:event_upcomingGame8ButtonActionPerformed

    private void upcomingGame9ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGame9ButtonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) upcomingScheduleTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) wagersTable.getModel();
        OverUnderFormula o = new OverUnderFormula();
        Object result = o.OverUnderCalc(51,60,15667,499,109,
                39,39,14922,353,102);
        Object[] row = new Object[2];
        model2.setRowCount(0);
        row[0] = model1.getValueAt(8,1);
        row[1] = model1.getValueAt(8,2);
        model2.addRow(row);
        model2.setValueAt(result,0,2);
        upcomingGamesPanel.setVisible(false);
        wagersPanel.setVisible(true);
    }//GEN-LAST:event_upcomingGame9ButtonActionPerformed

    private void upcomingGame10ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingGame10ButtonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) upcomingScheduleTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) wagersTable.getModel();
        OverUnderFormula o = new OverUnderFormula();
        Object result = o.OverUnderCalc(49,62,15101,417,129,
                                        41,67,13835,457,116);
        Object[] row = new Object[2];
        model2.setRowCount(0);
        row[0] = model1.getValueAt(9,1);
        row[1] = model1.getValueAt(9,2);
        model2.addRow(row);
        model2.setValueAt(result,0,2);
        upcomingGamesPanel.setVisible(false);
        wagersPanel.setVisible(true);
    }//GEN-LAST:event_upcomingGame10ButtonActionPerformed

    private void homeGoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeGoButtonActionPerformed
        homePanel.setVisible(false);
        int selection = homeTeamsComboBox.getSelectedIndex();
        switch (selection) {
            case 1:
                homePanel.setVisible(false);
                arsenalPanel.setVisible(true);
                break;
            case 2:
                homePanel.setVisible(false);
                astonPanel.setVisible(true);
                break;
            case 3:
                homePanel.setVisible(false);
                bournemouthPanel.setVisible(true);
                break;
            case 4:
                homePanel.setVisible(false);
                brightonPanel.setVisible(true);
                break;
            case 5:
                homePanel.setVisible(false);
                burnleyPanel.setVisible(true);
                break;
            case 6:
                homePanel.setVisible(false);
                chelseaPanel.setVisible(true);
                break;
            case 7:
                homePanel.setVisible(false);
                cpPanel.setVisible(true);
                break;
            case 8:
                homePanel.setVisible(false);
                evertonPanel.setVisible(true);
                break;
            case 9:
                homePanel.setVisible(false);
                lcPanel.setVisible(true);
                break;
            case 10:
                homePanel.setVisible(false);
                liverpoolPanel.setVisible(true);
                break;
            case 11:
                homePanel.setVisible(false);
                manCityPanel.setVisible(true);
                break;
            case 12:
                homePanel.setVisible(false);
                manUnitedPanel.setVisible(true);
                break;
            case 13:
                homePanel.setVisible(false);
                ncuPanel.setVisible(true);
                break;
            case 14:
                homePanel.setVisible(false);
                norwichPanel.setVisible(true);
                break;
            case 15:
                homePanel.setVisible(false);
                sheffieldPanel.setVisible(true);
                break;
            case 16:
                homePanel.setVisible(false);
                southamptonPanel.setVisible(true);
                break;
            case 17:
                homePanel.setVisible(false);
                tottenhamPanel.setVisible(true);
                break;
            case 18:
                homePanel.setVisible(false);
                watfordPanel.setVisible(true);
                break;
            case 19:
                homePanel.setVisible(false);
                whPanel.setVisible(true);
                break;
            case 20:
                homePanel.setVisible(false);
                wolvesPanel.setVisible(true);
                break;
            default:
                homePanel.setVisible(true);
                break;

        }
    }//GEN-LAST:event_homeGoButtonActionPerformed

    private void arsenalBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arsenalBackButtonActionPerformed
        arsenalPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_arsenalBackButtonActionPerformed

    private void astonBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_astonBackButtonActionPerformed
        astonPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_astonBackButtonActionPerformed

    private void bournemouthBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bournemouthBackButtonActionPerformed
        bournemouthPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_bournemouthBackButtonActionPerformed

    private void brightonBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brightonBackButtonActionPerformed
        brightonPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_brightonBackButtonActionPerformed

    private void burnleyBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_burnleyBackButtonActionPerformed
        burnleyPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_burnleyBackButtonActionPerformed

    private void chelseaBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chelseaBackButtonActionPerformed
        chelseaPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_chelseaBackButtonActionPerformed

    private void cpBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpBackButtonActionPerformed
        cpPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_cpBackButtonActionPerformed

    private void evertonBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evertonBackButtonActionPerformed
        evertonPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_evertonBackButtonActionPerformed

    private void lcBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lcBackButtonActionPerformed
        lcPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_lcBackButtonActionPerformed

    private void liverpoolBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liverpoolBackButtonActionPerformed
        liverpoolPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_liverpoolBackButtonActionPerformed

    private void manCityBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manCityBackButtonActionPerformed
        manCityPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_manCityBackButtonActionPerformed

    private void manUnitedBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manUnitedBackButtonActionPerformed
        manUnitedPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_manUnitedBackButtonActionPerformed

    private void ncuBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncuBackButtonActionPerformed
        ncuPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_ncuBackButtonActionPerformed

    private void norwichBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_norwichBackButtonActionPerformed
        norwichPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_norwichBackButtonActionPerformed

    private void sheffieldBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheffieldBackButtonActionPerformed
        sheffieldPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_sheffieldBackButtonActionPerformed

    private void southamptonBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_southamptonBackButtonActionPerformed
        southamptonPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_southamptonBackButtonActionPerformed

    private void tottenhamBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tottenhamBackButtonActionPerformed
        tottenhamPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_tottenhamBackButtonActionPerformed

    private void watfordBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watfordBackButtonActionPerformed
        watfordPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_watfordBackButtonActionPerformed

    private void whBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whBackButtonActionPerformed
        whPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_whBackButtonActionPerformed

    private void wolvesBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wolvesBackButtonActionPerformed
        wolvesPanel.setVisible(false);
        homePanel.setVisible(true);
    }//GEN-LAST:event_wolvesBackButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                myLogin.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton arsenalBackButton;
    private javax.swing.JLabel arsenalHeadingLabel;
    private javax.swing.JScrollPane arsenalJSP;
    private javax.swing.JLabel arsenalLogoLabel;
    private javax.swing.JPanel arsenalPanel;
    private javax.swing.JLabel arsenalScheduleLabel;
    private javax.swing.JTable arsenalTable;
    private javax.swing.JLabel arsenalTeamLabel;
    private javax.swing.JButton astonBackButton;
    private javax.swing.JLabel astonHeadingLabel;
    private javax.swing.JScrollPane astonJSP;
    private javax.swing.JLabel astonLogoLabel;
    private javax.swing.JPanel astonPanel;
    private javax.swing.JLabel astonScheduleLabel;
    private javax.swing.JTable astonTable;
    private javax.swing.JLabel astonTeamLabel;
    private javax.swing.JButton bournemouthBackButton;
    private javax.swing.JLabel bournemouthHeadingLabel;
    private javax.swing.JScrollPane bournemouthJSP;
    private javax.swing.JLabel bournemouthLogoLabel;
    private javax.swing.JPanel bournemouthPanel;
    private javax.swing.JLabel bournemouthScheduleLabel;
    private javax.swing.JTable bournemouthTable;
    private javax.swing.JLabel bournemouthTeamLabel;
    private javax.swing.JButton brightonBackButton;
    private javax.swing.JLabel brightonHeadingLabel;
    private javax.swing.JScrollPane brightonJSP;
    private javax.swing.JLabel brightonLogoLabel;
    private javax.swing.JPanel brightonPanel;
    private javax.swing.JLabel brightonScheduleLabel;
    private javax.swing.JTable brightonTable;
    private javax.swing.JLabel brightonTeamLabel;
    private javax.swing.JButton burnleyBackButton;
    private javax.swing.JLabel burnleyHeadingLabel;
    private javax.swing.JScrollPane burnleyJSP;
    private javax.swing.JLabel burnleyLogoLabel;
    private javax.swing.JPanel burnleyPanel;
    private javax.swing.JLabel burnleyScheduleLabel;
    private javax.swing.JTable burnleyTable;
    private javax.swing.JLabel burnleyTeamLabel;
    private javax.swing.JButton chelseaBackButton;
    private javax.swing.JLabel chelseaHeadingLabel;
    private javax.swing.JScrollPane chelseaJSP;
    private javax.swing.JLabel chelseaLogoLabel;
    private javax.swing.JPanel chelseaPanel;
    private javax.swing.JLabel chelseaScheduleLabel;
    private javax.swing.JTable chelseaTable;
    private javax.swing.JLabel chelseaTeamLabel;
    private javax.swing.JButton cpBackButton;
    private javax.swing.JLabel cpHeadingLabel;
    private javax.swing.JScrollPane cpJSP;
    private javax.swing.JLabel cpLogoLabel;
    private javax.swing.JPanel cpPanel;
    private javax.swing.JLabel cpScheduleLabel;
    private javax.swing.JTable cpTable;
    private javax.swing.JLabel cpTeamLabel;
    private javax.swing.JButton evertonBackButton;
    private javax.swing.JLabel evertonHeadingLabel;
    private javax.swing.JScrollPane evertonJSP;
    private javax.swing.JLabel evertonLogoLabel;
    private javax.swing.JPanel evertonPanel;
    private javax.swing.JLabel evertonScheduleLabel;
    private javax.swing.JTable evertonTable;
    private javax.swing.JLabel evertonTeamLabel;
    private javax.swing.JButton homeGoButton;
    private javax.swing.JLabel homeHeadingLabel;
    private javax.swing.JScrollPane homeJSP;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton homeScoresButton;
    private javax.swing.JTable homeStandingsTable;
    private javax.swing.JComboBox<String> homeTeamsComboBox;
    private javax.swing.JButton homeUpcomingGamesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton lcBackButton;
    private javax.swing.JLabel lcHeadingLabel;
    private javax.swing.JScrollPane lcJSP;
    private javax.swing.JLabel lcLogoLabel;
    private javax.swing.JPanel lcPanel;
    private javax.swing.JLabel lcScheduleLabel;
    private javax.swing.JTable lcTable;
    private javax.swing.JLabel lcTeamLabel;
    private javax.swing.JButton liverpoolBackButton;
    private javax.swing.JLabel liverpoolHeadingLabel;
    private javax.swing.JScrollPane liverpoolJSP;
    private javax.swing.JLabel liverpoolLogoLabel;
    private javax.swing.JPanel liverpoolPanel;
    private javax.swing.JLabel liverpoolScheduleLabel;
    private javax.swing.JTable liverpoolTable;
    private javax.swing.JLabel liverpoolTeamLabel;
    private javax.swing.JLabel loginHeadingLabel;
    private javax.swing.JButton loginLoginButton;
    private javax.swing.JPanel loginPanel;
    private JPasswordField loginPasswordField;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JButton loginRegisterButton;
    private javax.swing.JLabel loginUsernameLabel;
    private javax.swing.JTextField loginUsernameTextField;
    private javax.swing.JButton manCityBackButton;
    private javax.swing.JLabel manCityHeadingLabel;
    private javax.swing.JScrollPane manCityJSP;
    private javax.swing.JLabel manCityLogoLabel;
    private javax.swing.JPanel manCityPanel;
    private javax.swing.JLabel manCityScheduleLabel;
    private javax.swing.JTable manCityTable;
    private javax.swing.JLabel manCityTeamLabel;
    private javax.swing.JButton manUnitedBackButton;
    private javax.swing.JLabel manUnitedHeadingLabel;
    private javax.swing.JScrollPane manUnitedJSP;
    private javax.swing.JLabel manUnitedLogoLabel;
    private javax.swing.JPanel manUnitedPanel;
    private javax.swing.JLabel manUnitedScheduleLabel;
    private javax.swing.JTable manUnitedTable;
    private javax.swing.JLabel manUnitedTeamLabel;
    private javax.swing.JButton ncuBackButton;
    private javax.swing.JLabel ncuHeadingLabel;
    private javax.swing.JScrollPane ncuJSP;
    private javax.swing.JLabel ncuLogoLabel;
    private javax.swing.JPanel ncuPanel;
    private javax.swing.JLabel ncuScheduleLabel;
    private javax.swing.JTable ncuTable;
    private javax.swing.JLabel ncuTeamLabel;
    private javax.swing.JButton norwichBackButton;
    private javax.swing.JLabel norwichHeadingLabel;
    private javax.swing.JScrollPane norwichJSP;
    private javax.swing.JLabel norwichLogoLabel;
    private javax.swing.JPanel norwichPanel;
    private javax.swing.JLabel norwichScheduleLabel;
    private javax.swing.JTable norwichTable;
    private javax.swing.JLabel norwichTeamLabel;
    private javax.swing.JLabel registerHeadingLabel;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JPasswordField registerPasswordField;
    private javax.swing.JLabel registerPasswordLabel;
    private javax.swing.JButton registerRegisterButton;
    private javax.swing.JScrollPane registerTermsJSP;
    private javax.swing.JTextArea registerTermsTextArea;
    private javax.swing.JLabel registerUsernameLabel;
    private javax.swing.JTextField registerUsernameTextField;
    private javax.swing.JButton resultsBackButton;
    private javax.swing.JLabel resultsHeadingLabel;
    private javax.swing.JScrollPane resultsJSP;
    private javax.swing.JPanel resultsPanel;
    private javax.swing.JTable resultsScoresTable;
    private javax.swing.JButton sheffieldBackButton;
    private javax.swing.JLabel sheffieldHeadingLabel;
    private javax.swing.JScrollPane sheffieldJSP;
    private javax.swing.JLabel sheffieldLogoLabel;
    private javax.swing.JPanel sheffieldPanel;
    private javax.swing.JLabel sheffieldScheduleLabel;
    private javax.swing.JTable sheffieldTable;
    private javax.swing.JLabel sheffieldTeamLabel;
    private javax.swing.JButton southamptonBackButton;
    private javax.swing.JLabel southamptonHeadingLabel;
    private javax.swing.JScrollPane southamptonJSP;
    private javax.swing.JLabel southamptonLogoLabel;
    private javax.swing.JPanel southamptonPanel;
    private javax.swing.JLabel southamptonScheduleLabel;
    private javax.swing.JTable southamptonTable;
    private javax.swing.JLabel southamptonTeamLabel;
    private javax.swing.JButton thankYouExitButton;
    private javax.swing.JButton thankYouHomeButton;
    private javax.swing.JScrollPane thankYouJSP;
    private javax.swing.JPanel thankYouPanel;
    private javax.swing.JTextArea thankYouTextArea;
    private javax.swing.JButton tottenhamBackButton;
    private javax.swing.JLabel tottenhamHeadingLabel;
    private javax.swing.JScrollPane tottenhamJSP;
    private javax.swing.JLabel tottenhamLogoLabel;
    private javax.swing.JPanel tottenhamPanel;
    private javax.swing.JLabel tottenhamScheduleLabel;
    private javax.swing.JTable tottenhamTable;
    private javax.swing.JLabel tottenhamTeamLabel;
    private javax.swing.JButton upcomingBackButton;
    private javax.swing.JButton upcomingGame10Button;
    private javax.swing.JButton upcomingGame1Button;
    private javax.swing.JButton upcomingGame2Button;
    private javax.swing.JButton upcomingGame3Button;
    private javax.swing.JButton upcomingGame4Button;
    private javax.swing.JButton upcomingGame5Button;
    private javax.swing.JButton upcomingGame6Button;
    private javax.swing.JButton upcomingGame7Button;
    private javax.swing.JButton upcomingGame8Button;
    private javax.swing.JButton upcomingGame9Button;
    private javax.swing.JPanel upcomingGamesPanel;
    private javax.swing.JButton upcomingGoButton;
    private javax.swing.JLabel upcomingHeadingLabel;
    private javax.swing.JComboBox<String> upcomingJCB;
    private javax.swing.JScrollPane upcomingJSP;
    private javax.swing.JTable upcomingScheduleTable;
    private javax.swing.JButton wagersBackButton;
    private javax.swing.ButtonGroup wagersButtonGroup;
    private javax.swing.JLabel wagersHeadingLabel;
    private javax.swing.JScrollPane wagersJSP;
    private javax.swing.JRadioButton wagersOverRB;
    private javax.swing.JPanel wagersPanel;
    private javax.swing.JButton wagersSubmitButton;
    private javax.swing.JTable wagersTable;
    private javax.swing.JRadioButton wagersUnderRB;
    private javax.swing.JTextField wagersWagerTextField;
    private javax.swing.JButton watfordBackButton;
    private javax.swing.JLabel watfordHeadingLevel;
    private javax.swing.JScrollPane watfordJSP;
    private javax.swing.JLabel watfordLogoLabel;
    private javax.swing.JPanel watfordPanel;
    private javax.swing.JLabel watfordScheduleLabel;
    private javax.swing.JTable watfordTable;
    private javax.swing.JLabel watfordTeamLabel;
    private javax.swing.JButton whBackButton;
    private javax.swing.JLabel whHeadingLevel;
    private javax.swing.JScrollPane whJSP;
    private javax.swing.JLabel whLogoLabel;
    private javax.swing.JPanel whPanel;
    private javax.swing.JLabel whScheduleLabel;
    private javax.swing.JTable whTable;
    private javax.swing.JLabel whTeamLabel;
    private javax.swing.JButton wolvesBackButton;
    private javax.swing.JLabel wolvesHeadingLevel;
    private javax.swing.JScrollPane wolvesJSP;
    private javax.swing.JLabel wolvesLogoLabel;
    private javax.swing.JPanel wolvesPanel;
    private javax.swing.JLabel wolvesScheduleLabel;
    private javax.swing.JTable wolvesTable;
    private javax.swing.JLabel wolvesTeamLabel;
    // End of variables declaration//GEN-END:variables
}
