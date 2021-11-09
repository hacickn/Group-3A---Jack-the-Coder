import './App.css';
import BilboardButton from './components/BilboardButton';
import Colors from './utils/Colors';
import { makeStyles } from '@mui/styles';

const useStyles = makeStyles({
  root: {
    backgroundColor: Colors.BILBOARD_BLACK,
    height: '100vh',
    width: '100vw',
  },
});

function App() {
  const classes = useStyles();
  return (
    <div className="App">
      <div className={classes.root}>
        
      </div>
    </div>
  );
}

export default App;
