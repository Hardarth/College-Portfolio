import javax.swing.JOptionPane;
import java.lang.System.*;
import java.util.ArrayList;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;





public class Main extends JFrame{
	
	JFrame frame;
	JLabel displayField;
	ImageIcon image;
	
	public Main(String f)
	{
		frame = new JFrame("Image Display Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		try {
			image = new ImageIcon(getClass().getResource(f + ".png"));
			displayField = new JLabel(image);
			frame.add(displayField);
		}catch(Exception e) {
			System.out.println("Image cannot be found!");
		}
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	ImageIcon dab = new ImageIcon("biceps-curl-strength-curve.jpg");
	public static void main(String[] args) {
			ArrayList<String> workouts = new ArrayList<String>();
			workouts.add("Chest: Bench Press, Incline Dumbbell Press, Bar Dips, Standing Cable Chest Fly");
			workouts.add("Shoulder: Overhead Press, Seated Dumbbell Shoulder Press, Dumbbell Lateral Raise, Reverse Dumbbell Fly");
			workouts.add("Back: Deadlist, Lat Pulldown, Pull-Up, Barbell Row, Dumbell Row");
			workouts.add("Bicep: Barbell Curl, Dumbbell Curl, Hammer Curl");
			workouts.add("Tricep: Barbell Lying Triceps Extension, Overhead Cable Triceps Extension, Tricep Pushdown, Close-Grip Bench Press");
			workouts.add("Quadricep: Squat, Hack Squats, Leg Extension, Bulgarian Split Squat");
			workouts.add("Hamstring: Seated Leg Curl, Lying Leg Curl, Romanian Deadlift");
			workouts.add("Glute: Squat, Hip Thrust, Romanian Deadlift, Bulgarian Split Squat");
			workouts.add("Ab: Cable Crunch, Hanging Leg Raise, High to Low Wood Chop, Crunch");
			workouts.add("Calf Workouts: Standing Calf Raise, Seated Calf Raise");
			
			String name = JOptionPane.showInputDialog("Welcome to the workout and dietary health plan app, Enter your name");
			
			int age = Integer.parseInt(JOptionPane.showInputDialog("Hello " + name + ", what is your age? "));
			
			if(age < 60 && age > 15) {
				String typeAdvice = JOptionPane.showInputDialog("You are the right age to use this app, would you like advice on a workout plan, or health?");
				String typeAdvice2 = typeAdvice.toLowerCase();
				if(typeAdvice2.contains("workout")) {
				    String group = JOptionPane.showInputDialog("What group would you like to workout?");
				    printWorkoutsByMuscleGroup(workouts, group);
				}	
				if(typeAdvice2.contains("health")) {
					int height = Integer.parseInt(JOptionPane.showInputDialog("What is your height in inches?"));
					int weight = Integer.parseInt(JOptionPane.showInputDialog("What is your weight in lbs?"));
					JOptionPane.showMessageDialog(null, "Your BMI is " + df.format(Main.getBMI(height, weight)) + ". Your percent body fat is " + df.format(Main.getBF(Main.getBMI(height, weight), age)));
				}
			}
			else if(age > 60) {
				JOptionPane.showMessageDialog(null,  "Sorry " + name + ", you're too old to use this app.");
			}
			else if(age < 15) {
				JOptionPane.showMessageDialog(null,  "Sorry " + name + ", you're too young to use this app, but here is some bicep workouts you may look at.");
				printWorkoutsByMuscleGroup(workouts, "bicep");
			}
	}
	public static double getBMI(double height, double weight) {
		return (weight/(Math.pow(height, 2)))*703;
	}
	public static double getBF(double bmi, double age) {
			return (bmi*1.2 + age*0.23);
	}
  public static void printWorkoutsByMuscleGroup(ArrayList<String> workouts, String muscleGroup) {
    String muscleGroupLowerCase = muscleGroup.toLowerCase();
    boolean foundGroup = false;
    for (String workout : workouts) {
      String group = workout.substring(0, workout.indexOf(':'));
      String groupLowerCase = group.toLowerCase();
      if(muscleGroupLowerCase.contains(groupLowerCase)) {
        String imageWorkout = JOptionPane.showInputDialog("Choose one: " + workout);
        imageWorkout = imageWorkout.replace(" ", "-")  ; 
        Main i = new Main(imageWorkout);
        foundGroup = true;
        break;
      }
    }
    if(!foundGroup) {
      JOptionPane.showMessageDialog(null, "Sorry, no workouts found for muscle group " + muscleGroup);
    }
  }
}

