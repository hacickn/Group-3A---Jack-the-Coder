import './App.css';
import Colors from './utils/Colors';
import LoginRegister from './screens/LoginRegister';
import { makeStyles } from '@mui/styles';
import BilboardTextField from './components/BilboardTextField';



function App() {
<<<<<<< Updated upstream
  const classes = useStyles()

  return (
    <div className="App">
      <div className={classes.root}>
        <BilboardTextField />
      </div>
=======
  
  return (
    <div className="App">
      <LoginRegister />
>>>>>>> Stashed changes
    </div>
  );
}

export default App;
