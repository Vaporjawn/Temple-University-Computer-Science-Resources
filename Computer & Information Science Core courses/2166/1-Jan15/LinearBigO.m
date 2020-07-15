%% Inventory example
% Here constant $C$ is chosen to be 1
n = linspace(0,20,100);
T = 10 + 2*n;
f = 1*n;

figure(1)
plot(n,T, 'linewidth', 2, 'color', 'g')
xlim([0 20])
ylim([0 50])
hold on
plot(n,f, 'linewidth', 2, 'color', 'b')
legend('T(n) = 10 + 2 n', 'f(n) = n', 'location', 'northwest')
%title('T(n) dominates f(n) everywhere')

%%
% Now we choose the constant $C$ to 5 
figure(2)
f = 5*n; 
plot(n,T, 'linewidth', 2, 'color', 'g')
xlim([0 20])
ylim([0 50])
hold on
plot(n,f, 'linewidth', 2, 'color', 'b')
legend('T(n) = 10 + 2 n', 'f(n) = 5 n', 'location', 'northwest')
%title('Now f(n) begins to dominate T(n) after a certain point')