import React, { useEffect, useState } from 'react';
import ReactDOM from 'react-dom/client';

const services = [
  ['Customer Service', '/api/customer/actuator/health'],
  ['Account Service', '/api/account/actuator/health'],
  ['Transaction Service', '/api/transaction/actuator/health'],
  ['Payment Service', '/api/payment/actuator/health'],
  ['Loan Service', '/api/loan/actuator/health'],
];

function App() {
  const [data, setData] = useState({});

  useEffect(() => {
    services.forEach(async ([name, url]) => {
      try {
        const response = await fetch(url);
        const result = await response.json();

        setData((previousData) => ({
          ...previousData,
          [name]: result,
        }));
      } catch (error) {
        setData((previousData) => ({
          ...previousData,
          [name]: {
            error: 'Service unavailable',
          },
        }));
      }
    });
  }, []);

  return (
    <div>
      <h1>Banking DevOps Platform</h1>

      {services.map(([name]) => (
        <div key={name}>
          <h3>{name}</h3>
          <pre>
            {JSON.stringify(
              data[name] || { status: 'Checking...' },
              null,
              2
            )}
          </pre>
        </div>
      ))}
    </div>
  );
}

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
