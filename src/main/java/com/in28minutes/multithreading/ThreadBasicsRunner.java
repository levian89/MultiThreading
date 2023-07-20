package com.in28minutes.multithreading;

//extends Thread
//implements Runnable

/*
Task1 Kicked Off
Task2 Kicked Off
Task1 Started
Task3 Kicked Off           |-> Task2 RUNNING, Task1 RUNNABLE in this moment
Task2 Started 101 201 102 202 103 203 301 104 302 204 205 303 304 305 105 106 306 206 307 308 309 310 311 312 313 314 315 316 317 318 107 319 207 320 321 108 109 322 208 323 324 325 110 111 112 113 326 209 210 327 114 328 211 212 329 115 116 330 213 214 331 117 332 215 216 333 118 334 217 218 335 336 337 338 339 340 341 119 342 343 344 345 346 347 348 349 350 351 352 353 354 355 356 357 358 359 360 361 362 363 120 219 121 364 122 220 123 365 124 221 125 366 126 222 127 367 128 223 129 130 131 132 133 134 135 368 136 224 137 369 138 225 139 370 371 372 373 374 140 226 141 375 142 227 143 376 144 228 145 377 146 229 147 378 379 148 149 150 151 230 231 232 152 380 153 233 154 381 155 234 156 382 157 235 158 383 159 236 160 384 161 237 162 385 163 238 164 386 165 239 166 387 167 240 168 388 169 241 170 389 171 242 172 390 173 243 174 391 175 244 176 392 177 245 178 393 179 246 180 394 181 247 182 395 183 248 184 396 185 249 186 397 187 250 188 398 189 251 190 399 191 252 192
Task3 Done 193 253 194
Main Done 195 254 196 255 197 256 198 257 199 258
Task1 Done 259 260 261 262 263 264 265 266 267 268 269 270 271 272 273 274 275 276 277 278 279 280 281 282 283 284 285 286 287 288 289 290 291 292 293 294 295 296 297 298 299
Task2 Done
 */

//•	NEW - a Thread is in this state, after it's being created but before execution of start method (for ex.
//                                                                              Task1 task1 = new Task1();)
//•	RUNNABLE
//•	RUNNING    |-> a Thread is in this state when it's waiting for some other Thread to provide some data that it's
//•	BLOCKED/WAITING                                                                         needed by the first one
//    |-> a Thread is in this state when it's waiting for an external service to respond or it's waiting for
//    a slow response from a database
//•	TERMINATED/DEAD
//      |-> a Thread is in this state after finishing execution (for ex. Task1 Done)



class Task1 extends Thread {
    public void run() { //Signature
        System.out.print("\nTask1 Started ");
        for(int i=101;i<=199;i++)
            System.out.print(i + " ");
        System.out.print("\nTask1 Done ");
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.print("\nTask2 Started ");
        for(int i=201;i<=299;i++)
            System.out.print(i + " ");
        Thread.yield();// a hint to the scheduler that the current thread is willing to yield its current use of a processor
        System.out.print("\nTask2 Done ");
    }
}

public class ThreadBasicsRunner {
    public static void main(String[] args) throws InterruptedException {
        //Task1 - 101 to 199
        System.out.print("Task1 Kicked Off ");
        Task1 task1 = new Task1();
//        task1.setPriority(1);
        task1.start();
        //Task2
        System.out.print("\nTask2 Kicked Off ");
//        Thread.sleep(2000); // the current thread temporarily cease execution for the specified number of milliseconds
//        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(new Task2());
//        task2Thread.setPriority(10); // it's just a request, a hint; not an order.
        task2Thread.start();
        // wait for task1 to complete execution
        task1.join();
        // wait for task2Thread to complete execution
        task2Thread.join();
        //Task3
        System.out.print("\nTask3 Kicked Off ");
        for(int i=301;i<=399;i++)
            System.out.print(i + " ");
        System.out.print("\nTask3 Done ");
        System.out.print("\nMain Done ");
    }
}