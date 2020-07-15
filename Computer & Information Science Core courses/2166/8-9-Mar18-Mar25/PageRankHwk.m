format rat
% the connected web example from the paper:
A1 = [ 0   0   1  1/2;
      1/3  0   0   0 ;
      1/3 1/2  0  1/2;
      1/3 1/2  0   0]
  
[V D] = eig(A1);
disp('the eigenvector associated with eigenvalue 1:')
V(:,1)*(12/V(1,1)) %just scaling the eigenvector so that it looks prettier

disp('the ranking of pages for A:')
x = V(:,1)/sum(V(:,1))

figure(1)
bar(x, 'FaceColor',[0 .5 .5],'EdgeColor',[0 .9 .9],'LineWidth',1.5)
title('Google Page Rank, Tiny Web Example')
xlabel('Page ID') 
ylabel('Page Rank') 

% EXERCISE 1: 
%  Create page 5 so that it links to page 3, and page 3 links to page 5.
%  Since page 3 now gets a full vote of one, and page 1 gets no new vote
%  (in fact its ranking has decreased because the relative 
% contribution of page 3's vote to page 1 has become lower), 3 ends up 
% ranked above page 1. Also plot the histogram of the new rankings.
%new A1
A1 = [ 0              0              1/2            1/2            0  ;     
       1/3            0              0              0              0  ;   
       1/3            1/2            0              1/2            1  ;     
       1/3            1/2            0              0              0  ;    
       0              0              1/2            0              0 ]

[V D] = eig(A1);
disp('the eigenvector associated with eigenvalue 1:')
V(:,1);
x = V(:,1)/sum(V(:,1))
figure(2)
bar(x, 'EdgeColor',[0 .9 .9],'LineWidth',1)
title('Exercise 1')
xlabel('Page ID') 
ylabel('Page Rank') 


%% Exercise 11
clear all; close all
A = [ 0              0              1/2            1/2            0  ;     
       1/3            0              0              0              0  ;   
       1/3            1/2            0              1/2            1  ;     
       1/3            1/2            0              0              0  ;    
       0              0              1/2            0              0 ];

S = 1/5 * ones(5)
m = 0.15;
M = (1 - m )*A + m*S 
[V D] = eig(M)
%real(diag(D))
ranks = V(:,1) / sum(V(:,1))
bar(ranks, 'FaceColor',[0 .5 .5],'EdgeColor',[0 .9 .9],'LineWidth',1.5)
title('Exercise 11')
xlabel('Page ID') 
ylabel('Page Rank') 






